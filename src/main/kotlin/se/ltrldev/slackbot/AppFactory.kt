package se.ltrldev.slackbot

import com.slack.api.bolt.App
import com.slack.api.bolt.AppConfig
import com.slack.api.bolt.context.builtin.SlashCommandContext
import com.slack.api.bolt.request.builtin.SlashCommandRequest
import com.slack.api.model.event.AppMentionEvent
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton


@Factory
class AppFactory {
  @Singleton
  fun createAppConfig(): AppConfig {
    return AppConfig() // loads the env variables
  }

  @Singleton
  fun createApp(config: AppConfig?): App {
    val app = App(config)
    app.command("/hello") { req: SlashCommandRequest?, ctx: SlashCommandContext -> ctx.ack(":wave: Hello!") }

    app.event(AppMentionEvent::class.java) { event, ctx ->
      ctx.say("<@${event.event.user}> What's up?")
      ctx.ack()
    }
    return app
  }
}
