package com.fulrich.aoc.submarine.entertainment

import bingo.{Game => Bingo, GameSetup}

class EntertainmentSystem:
  def bingo(setup: GameSetup): Bingo = Bingo(setup)
