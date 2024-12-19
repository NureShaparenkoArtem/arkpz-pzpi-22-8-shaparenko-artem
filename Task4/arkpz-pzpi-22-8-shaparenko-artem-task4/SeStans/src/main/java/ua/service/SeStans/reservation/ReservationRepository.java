package ua.service.SeStans.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.service.SeStans.station.Station;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    public List<Reservation> findByReservationTime(LocalDateTime dateTime);
    public List<Reservation> findByStationAndReservationTime(Station station, LocalDateTime dateTime);
    public List<Reservation> findByMechanicNeed(Boolean bool);
}
