package com.fastcampus.springboot.autoconfigure.handgame

import com.fastcampus.springboot.handgame.Handgame
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean

@AutoConfiguration
@ConditionalOnClass(Handgame::class)
@ConditionalOnProperty(prefix = "my.handgame", name = ["enabled"], havingValue = "true")
class HandgameAutoconfiguration {

    @Bean
    @ConditionalOnMissingBean
    fun handgame() = Handgame()
}