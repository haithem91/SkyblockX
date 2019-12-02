package io.illyria.skyblockx.command.cmd

import io.illyria.skyblockx.Globals
import io.illyria.skyblockx.command.CommandRequirementsBuilder
import io.illyria.skyblockx.core.Permission
import io.illyria.skyblockx.gui.IslandQuestGUI
import io.illyria.skyblockx.persist.Data
import io.illyria.skyblockx.persist.Message

class CmdReload : io.illyria.skyblockx.command.SCommand() {

    init {
        aliases.add("reload")

        commandRequirements = CommandRequirementsBuilder().withPermission(Permission.RELOAD).build()
    }


    override fun perform(info: io.illyria.skyblockx.command.CommandInfo) {
        Data.save()
        Globals.skyblockX.loadDataFiles()
        Globals.skyblockX.setupOreGeneratorAlgorithm()
        info.message(Message.commandReloadSuccess)


    }


    override fun getHelpInfo(): String {
        return Message.commandReloadHelp
    }
}