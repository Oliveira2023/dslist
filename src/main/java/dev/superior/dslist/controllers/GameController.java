package dev.superior.dslist.controllers;

import dev.superior.dslist.dto.GameDTO;
import dev.superior.dslist.dto.GameListDTO;
import dev.superior.dslist.dto.GameMinDTO;
import dev.superior.dslist.service.GameListService;
import dev.superior.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;
    @Autowired
    private GameListService gameListService;

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }

    @GetMapping(value = "/gamelist")
    public List<GameListDTO> findGameList() {
        List<GameListDTO> result = gameListService.findGameList();
        return result;
    }
}
