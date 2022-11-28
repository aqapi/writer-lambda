package pl.kozubek.writerlambda.app.station.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kozubek.writerlambda.app.data.model.MeasuringData;
import pl.kozubek.writerlambda.app.data.model.dto.MeasuringDataDto;
import pl.kozubek.writerlambda.app.data.service.MeasuringDataService;
import pl.kozubek.writerlambda.app.station.mapper.MeasuringStationMapper;
import pl.kozubek.writerlambda.app.station.model.MeasuringCity;
import pl.kozubek.writerlambda.app.station.model.MeasuringCityCommune;
import pl.kozubek.writerlambda.app.station.model.MeasuringStation;
import pl.kozubek.writerlambda.app.station.model.dto.MeasuringStationDto;
import pl.kozubek.writerlambda.app.station.service.mapper.CityDtoMapper;
import pl.kozubek.writerlambda.app.station.service.mapper.CommuneDtoMapper;
import pl.kozubek.writerlambda.app.station.service.mapper.StationDtoMapper;
import pl.kozubek.writerlambda.webClient.MeasuringClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeasuringStationService {
    private final MeasuringStationMapper stationMapper;
    private final StationDtoMapper stationDtoMapper;
    private final CityDtoMapper cityDtoMapper;
    private final CommuneDtoMapper communeDtoMapper;

    public void addMeasuringStation(MeasuringStation station) {
        stationMapper.addMeasuringStation(station);
    }

    @Transactional
    public void addMeasuringStationWithCityAndCommune(MeasuringStationDto stationDto) {
        MeasuringCityCommune commune = communeDtoMapper.to(stationDto.getCity().getCommune());
        MeasuringCity city = cityDtoMapper.to(stationDto.getCity());
        MeasuringStation station = stationDtoMapper.to(stationDto);

        if (stationMapper.existCommuneByCommuneNameAndDistrictNameAndProvinceName(commune.getCommuneName(),
                commune.getDistrictName(),
                commune.getProvinceName()))
            stationMapper.addMeasuringCommune(commune);
        if (stationMapper.existCityById(city.getId())) {
            city.setCommune(commune.getId());
            stationMapper.addMeasuringCity(city);
        }
        if (stationMapper.existStationById(station.getId()))
            stationMapper.addMeasuringStation(station);
    }
}
