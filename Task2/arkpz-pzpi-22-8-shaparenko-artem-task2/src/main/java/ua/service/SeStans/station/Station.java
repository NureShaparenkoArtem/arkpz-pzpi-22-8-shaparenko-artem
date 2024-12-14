package ua.service.SeStans.station;

import jakarta.persistence.*;
import org.w3c.dom.Text;
import ua.service.SeStans.station.owner.Owner;

import java.time.LocalTime;

@Entity
@Table(name = "Stations")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer station_id;
    private String station_name;
    private String station_type;
    private String location;
    private LocalTime opening_time;
    private LocalTime closing_time;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    private Float station_profit;
    private String available_tools;

    public Station() {
    }

    public Station(Integer station_id,
                   String station_name,
                   String station_type,
                   String location,
                   LocalTime opening_time,
                   LocalTime closing_time,
                   Owner owner,
                   Float station_profit,
                   String available_tools) {
        this.station_id = station_id;
        this.station_name = station_name;
        this.station_type = station_type;
        this.location = location;
        this.opening_time = opening_time;
        this.closing_time = closing_time;
        this.owner = owner;
        this.station_profit = station_profit;
        this.available_tools = available_tools;
    }

    public Station(String station_name,
                   String station_type,
                   String location,
                   LocalTime opening_time,
                   LocalTime closing_time,
                   Owner owner,
                   Float station_profit,
                   String available_tools) {
        this.station_name = station_name;
        this.station_type = station_type;
        this.location = location;
        this.opening_time = opening_time;
        this.closing_time = closing_time;
        this.owner = owner;
        this.station_profit = station_profit;
        this.available_tools = available_tools;
    }

    public Integer getStation_id() {
        return station_id;
    }

    public void setStation_id(Integer station_id) {
        this.station_id = station_id;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public String getStation_type() {
        return station_type;
    }

    public void setStation_type(String station_type) {
        this.station_type = station_type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalTime getOpening_time() {
        return opening_time;
    }

    public void setOpening_time(LocalTime opening_time) {
        this.opening_time = opening_time;
    }

    public LocalTime getClosing_time() {
        return closing_time;
    }

    public void setClosing_time(LocalTime closing_time) {
        this.closing_time = closing_time;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Float getStation_profit() {
        return station_profit;
    }

    public void setStation_profit(Float station_profit) {
        this.station_profit = station_profit;
    }

    public String getAvailable_tools() {
        return available_tools;
    }

    public void setAvailable_tools(String available_tools) {
        this.available_tools = available_tools;
    }

    @Override
    public String toString() {
        return "Station{" +
                "station_id=" + station_id +
                ", station_name='" + station_name + '\'' +
                ", station_type='" + station_type + '\'' +
                ", location='" + location + '\'' +
                ", opening_time=" + opening_time +
                ", closing_time=" + closing_time +
                ", owner=" + owner +
                ", station_profit=" + station_profit +
                ", available_tools='" + available_tools + '\'' +
                '}';
    }
}
