#include <WiFi.h>
#include <PubSubClient.h>

const char* ssid = "Wokwi-GUEST";
const char* password = "";

const char* mqtt_server = "broker.emqx.io";
const int mqtt_port = 1883;
const char* mqtt_topic = "station/status";

WiFiClient espClient;
PubSubClient client(espClient);

bool stationOccupied = false;

#define TRIG_PIN 27
#define ECHO_PIN 26
const int RED_LED = 33;
const int GREEN_LED = 25;

const float DETECTION_THRESHOLD = 35.0;

void setup() {
  Serial.begin(115200);
  pinMode(TRIG_PIN, OUTPUT);
  pinMode(ECHO_PIN, INPUT);
  pinMode(RED_LED, OUTPUT);
  pinMode(GREEN_LED, OUTPUT);

  digitalWrite(RED_LED, LOW);
  digitalWrite(GREEN_LED, HIGH);

  connectToWiFi();

  client.setServer(mqtt_server, mqtt_port);
}

void loop() {
  if (!client.connected()) {
    reconnect();
  }
  client.loop();

  float distance = measureDistance();
  if (distance < DETECTION_THRESHOLD && !stationOccupied) {
    stationOccupied = true;
    sendStationStatus(false);
    digitalWrite(RED_LED, HIGH);
    digitalWrite(GREEN_LED, LOW);
  } else if (distance >= DETECTION_THRESHOLD && stationOccupied) {
    stationOccupied = false;
    sendStationStatus(true);
    digitalWrite(RED_LED, LOW);
    digitalWrite(GREEN_LED, HIGH);
  }

  delay(1000);
}

float measureDistance() {
  digitalWrite(TRIG_PIN, LOW);
  delayMicroseconds(2);
  digitalWrite(TRIG_PIN, HIGH);
  delayMicroseconds(10);
  digitalWrite(TRIG_PIN, LOW);

  long duration = pulseIn(ECHO_PIN, HIGH);
  return duration * 0.034 / 2;
}

void connectToWiFi() {
  Serial.print("Connecting to WiFi...");
  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("Connected to WiFi!");
}

void reconnect() {
  while (!client.connected()) {
    if (client.connect("ESP32Client")) {
    } else {
      delay(5000);
    }
  }
}

void sendStationStatus(bool isFree) {
  String jsonPayload = "{"
                       "\"stationId\": 5,"
                       "\"isFree\": " + String(isFree ? "true" : "false") +
                       "}";

  if (client.publish(mqtt_topic, jsonPayload.c_str())) {
    Serial.println("Status sent: " + jsonPayload);
  } else {
    Serial.println("Failed to send status");
  }
}
