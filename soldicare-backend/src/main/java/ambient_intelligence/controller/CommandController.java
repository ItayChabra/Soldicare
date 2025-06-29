package ambient_intelligence.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ambient_intelligence.domain.boundary.CommandBoundary;
import ambient_intelligence.logic.CommandsService;

@RestController
@RequestMapping(path = { "/ambient-intelligence/commands" })
public class CommandController {

    private final CommandsService commandService;

    public CommandController(CommandsService commandService) {
        this.commandService = commandService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object invokeCommand(@RequestBody CommandBoundary command) {
        return commandService.invokeCommand(command);
    }
}
