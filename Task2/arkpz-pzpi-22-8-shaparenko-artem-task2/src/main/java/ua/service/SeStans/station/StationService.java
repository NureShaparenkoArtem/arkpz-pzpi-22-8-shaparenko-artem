package ua.service.SeStans.station;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.service.SeStans.mechanic.Mechanic;
import ua.service.SeStans.station.owner.Owner;
import ua.service.SeStans.station.owner.OwnerRepository;
import ua.service.SeStans.user.User;
import ua.service.SeStans.vehicle.Vehicle;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class StationService {
    private final StationRepository stationRepository;
    private final OwnerRepository ownerRepository;

    @Autowired
    public StationService(StationRepository stationRepository, OwnerRepository ownerRepository) {
        this.stationRepository = stationRepository;
        this.ownerRepository = ownerRepository;
    }

    public List<Station> getStations(){
        return stationRepository.findAll();
    }

    public Station createStation(String stationName,
                                 String stationType,
                                 String location,
                                 LocalTime openingTime,
                                 LocalTime closingTime,
                                 Integer ownerId,
                                 Float stationProfit,
                                 String availableTools) {
        Owner owner = ownerRepository.findById(ownerId).orElseThrow(() ->
                new IllegalArgumentException("Owner not found with ID: " + ownerId));

        Station station = new Station(stationName, stationType, location, openingTime, closingTime, owner, stationProfit, availableTools);

        return stationRepository.save(station);
    }

    public Station updateStation(Integer stationId,
                                 String stationName,
                                 String stationType,
                                 String location,
                                 LocalTime openingTime,
                                 LocalTime closingTime,
                                 Integer ownerId,
                                 Float stationProfit,
                                 String availableTools){
        Station existingStation = stationRepository.findById(stationId).orElseThrow(() ->
                new IllegalArgumentException("Station not found with ID: " + stationId));

        Owner owner = ownerRepository.findById(ownerId).orElseThrow(() ->
                new IllegalArgumentException("Owner not found with ID: " + ownerId));

        existingStation.setStation_name(stationName);
        existingStation.setStation_type(stationType);
        existingStation.setLocation(location);
        existingStation.setOpening_time(openingTime);
        existingStation.setClosing_time(closingTime);
        existingStation.setOwner(owner);
        existingStation.setStation_profit(stationProfit);
        existingStation.setAvailable_tools(availableTools);

        return stationRepository.save(existingStation);
    }

    public void deleteStation(Integer stationId){
        if (!stationRepository.existsById(stationId)) {
            throw new IllegalArgumentException("Station not found with ID: " + stationId);
        }

        stationRepository.deleteById(stationId);
    }
}
