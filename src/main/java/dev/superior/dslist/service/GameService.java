package dev.superior.dslist.service;

import dev.superior.dslist.dto.GameDTO;
import dev.superior.dslist.dto.GameListDTO;
import dev.superior.dslist.dto.GameMinDTO;
import dev.superior.dslist.entities.Game;
import dev.superior.dslist.entities.GameList;
import dev.superior.dslist.projections.GameMinProjection;
import dev.superior.dslist.repositories.GameListRepository;
import dev.superior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).orElseThrow();
        return new GameDTO(result);
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
}
