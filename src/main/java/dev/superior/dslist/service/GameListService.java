package dev.superior.dslist.service;

import dev.superior.dslist.dto.GameDTO;
import dev.superior.dslist.dto.GameListDTO;
import dev.superior.dslist.dto.GameMinDTO;
import dev.superior.dslist.entities.Game;
import dev.superior.dslist.entities.GameList;
import dev.superior.dslist.repositories.GameListRepository;
import dev.superior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findGameList() {
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }
}
