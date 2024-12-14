package ua.service.SeStans.reservation;

import jakarta.persistence.*;
import ua.service.SeStans.mechanic.Mechanic;
import ua.service.SeStans.station.Station;
import ua.service.SeStans.vehicle.Vehicle;

import java.time.LocalDateTime;

@Entity
@Table(name = "Reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservation_id;
    private LocalDateTime reservation_time;
    private LocalDateTime reservation_end_time;
    private String status;
    private Boolean mechanic_need;
    private Float price;
    @OneToOne
    @JoinColumn(name = "station_id")
    private Station station;
    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @OneToOne
    @JoinColumn(name = "mechanic_id")
    private Mechanic mechanic;

    public Reservation() {
    }

    public Reservation(Integer reservation_id,
                       LocalDateTime reservation_time,
                       LocalDateTime reservation_end_time,
                       String status,
                       Boolean mechanic_need,
                       Float price,
                       Station station,
                       Vehicle vehicle,
                       Mechanic mechanic) {
        this.reservation_id = reservation_id;
        this.reservation_time = reservation_time;
        this.reservation_end_time = reservation_end_time;
        this.status = status;
        this.mechanic_need = mechanic_need;
        this.price = price;
        this.station = station;
        this.vehicle = vehicle;
        this.mechanic = mechanic;
    }

    public Reservation(LocalDateTime reservation_time,
                       LocalDateTime reservation_end_time,
                       String status,
                       Boolean mechanic_need,
                       Float price,
                       Station station,
                       Vehicle vehicle,
                       Mechanic mechanic) {
        this.reservation_time = reservation_time;
        this.reservation_end_time = reservation_end_time;
        this.status = status;
        this.mechanic_need = mechanic_need;
        this.price = price;
        this.station = station;
        this.vehicle = vehicle;
        this.mechanic = mechanic;
    }

    public Integer getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Integer reservation_id) {
        this.reservation_id = reservation_id;
    }

    public LocalDateTime getReservation_time() {
        return reservation_time;
    }

    public void setReservation_time(LocalDateTime reservation_time) {
        this.reservation_time = reservation_time;
    }

    public LocalDateTime getReservation_end_time() {
        return reservation_end_time;
    }

    public void setReservation_end_time(LocalDateTime reservation_end_time) {
        this.reservation_end_time = reservation_end_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getMechanic_need() {
        return mechanic_need;
    }

    public void setMechanic_need(Boolean mechanic_need) {
        this.mechanic_need = mechanic_need;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservation_id=" + reservation_id +
                ", reservation_time=" + reservation_time +
                ", reservation_end_time=" + reservation_end_time +
                ", status='" + status + '\'' +
                ", mechanic_need=" + mechanic_need +
                ", price=" + price +
                ", station=" + station +
                ", vehicle=" + vehicle +
                ", mechanic=" + mechanic +
                '}';
    }
}