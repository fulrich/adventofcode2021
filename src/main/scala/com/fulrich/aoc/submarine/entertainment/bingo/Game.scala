package com.fulrich.aoc.submarine.entertainment.bingo

import scala.annotation.tailrec

class Game(setup: GameSetup):
  @tailrec
  final def play(round: Int = 0, activeCards: Seq[Card] = setup.cards): Card = {
    val playedCards = activeCards.map(_.mark(setup.draws(round)))
    val winningCard = playedCards.find(_.winner)

    if winningCard.isDefined then winningCard.get else play(round + 1, playedCards)
  }

  @tailrec
  final def playToLose(round: Int = 0, activeCards: Seq[Card] = setup.cards): Card = {
    val playedCards = activeCards.map(_.mark(setup.draws(round)))
    val winningCards = playedCards.filter(_.winner)
    val remainingCards = playedCards.filter(card => !card.winner)

    if remainingCards.isEmpty then winningCards.last else playToLose(round + 1, remainingCards)
  }
