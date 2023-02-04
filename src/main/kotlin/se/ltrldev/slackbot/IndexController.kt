package se.ltrldev.slackbot

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/")
class IndexController {
  @Get(produces = [MediaType.APPLICATION_JSON])
  fun index(): String {
    return "{\"status\": \"up\"}"
  }
}
