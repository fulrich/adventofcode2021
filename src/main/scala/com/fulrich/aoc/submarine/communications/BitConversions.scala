package com.fulrich.aoc.submarine.communications

extension (c: Char)
  def hexToBinary: String = c.toString.hexToBinary

extension (c: String)
  def hexToBinary: String = Integer.parseInt(c, 16).toBinaryString.reverse.padTo(4,  '0').reverse
  def binaryToDecimal: Long = BigInt(c, 2).toLong

