package com.example.trackobstaclecourse

class Obstacles {

    // Potental thing of note, if we have a value for what track the obstacle
    // is, do we need an x value?
    inner class Obstacle (xIn : Float, yIn: Float, trackIn : Int) {
        private val xPos : Float = xIn // x position
        private val yPos : Float = yIn // y position
        private val track : Int = trackIn // determines which track the obstacle will be on

        fun returnX () : Float {return xPos}
        fun returnY () : Float {return yPos}
        fun returnTrack () : Float {return xPos}
    }

    // Potental thing of note, if we have a value for what track the obstacle
    // is, do we need an x value? We could just store the track value which
    // would then just tell us where the player is. We could have a switch
    // function for x and just call it whenever we want the x value
    companion object player {
        val xPos : Float = 0.0F
        val yPos : Float = 0.0F
        val avatar : String = ""
    }


}