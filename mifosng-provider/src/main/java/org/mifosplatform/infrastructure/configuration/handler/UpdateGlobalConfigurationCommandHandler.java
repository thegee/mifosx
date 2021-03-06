package org.mifosplatform.infrastructure.configuration.handler;

import org.mifosplatform.commands.handler.NewCommandSourceHandler;
import org.mifosplatform.infrastructure.configuration.service.GlobalConfigurationWritePlatformService;
import org.mifosplatform.infrastructure.core.api.JsonCommand;
import org.mifosplatform.infrastructure.core.data.CommandProcessingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateGlobalConfigurationCommandHandler implements NewCommandSourceHandler {

    private final GlobalConfigurationWritePlatformService writePlatformService;

    @Autowired
    public UpdateGlobalConfigurationCommandHandler(final GlobalConfigurationWritePlatformService writePlatformService) {
        this.writePlatformService = writePlatformService;
    }

    @Transactional
    @Override
    public CommandProcessingResult processCommand(final JsonCommand command) {

        return this.writePlatformService.update(command);
    }
}