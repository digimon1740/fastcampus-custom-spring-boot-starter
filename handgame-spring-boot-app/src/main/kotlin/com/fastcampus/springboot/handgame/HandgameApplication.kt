package com.fastcampus.springboot.handgame

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class HandgameApplication (
    // 의존성 주입된 Handgame
    val handgame: Handgame
) : CommandLineRunner {

    val logger = LoggerFactory.getLogger(Handgame::class.java)

    override fun run(vararg args: String) {
        val myCommands = buildList {
            add(GameCommand.바위)
            add(GameCommand.가위)
            add(GameCommand.보)
            add(GameCommand.가위)
        }

        myCommands.forEach {
            val (result, opponentCommand) = handgame.play(it)
            logger.info("나 : {}, 상대방 : {}, 결과 : {}", it, opponentCommand, result)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<HandgameApplication>(*args)
}
