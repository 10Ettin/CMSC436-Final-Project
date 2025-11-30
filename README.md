# CMSC436-Final-Project

## Project requirements:
1. Nice looking icon for the app.
2. Must use the Model-View-Controller architecture.
3. Model for the app.
4. At least 3 views; at least 2 views should "use" the same data (either sharing or
passing the data).
5. There should be local, persistent meaningful data (for example you can enable
the user to set style preferences such as colors, ..); there must be at least 2
persistent variables.
6. There should be remote, persistent meaningful data. For example, you can
either use Firebase or the server we used for CMSC424 (if you are currently
taking CMSC424). That data should be different from (and more voluminous
than) the local persistent data. Ideally, your app is crowd-sourced. It should make
sense for the data to be stored remotely (i.e. if it could be sourced locally, then
that data is not a candidate for remore persistent data).
7. Includes meaningful use of either an app (for example, email, voice recognition,
..) or hardware (gps, accelerometer, ..) from the phone or some Google services(
maps, ..).
8. Uses at least two new GUI components not studied in class (rating bar, seek bar,
progress bar, analog clock, calendar view, ...).
9. There should be a listener registered on at least one of these 2 new GUI
components (and there should be code to do something meaningful).
10. Includes advertising (fake ad pulled from Google services).
11. Be a meaningful, good looking app with nice and significant functionality; should
look nice and clean, user friendly, intuitive (how to use it).

# Concept: 3 Track Obstacle Course
## Gameplay:
* The player is an icon that can move between 3 static “tracks” by pressing “left” and “right” buttons 
  - The player icon will be fixed on the y-axis at the bottom of the screen and will instantly snap to the x-coordinate of a track
  - Each track can be represented as a vertical line that stretches across the entire screen at 3 fixed x-coordinates (ie. track1_x=[⅓ of view + padding], track2_x=[⅔ of view + padding], track3_x=[3/3 of view - padding])
* A GameTimer will be implemented to allow constant updating of the game state
* Obstacle objects will appear from the top of the screen moving down the track until it reaches the bottom of the screen and disappears or collides with the player’s icon
  - Every interval, an obstacle object will randomly be placed on one of the three tracks (random number generator?)
  - Obstacles can move down the track snapping to a fixed set of y-coordinates (essentially the entire environment can be represented as a grid such as a 3x10 grid)
  - When the game state updates and an obstacle object is the same (x,y) coordinate as the player’s icon, a “hit” is registered which either ends the game or subtracts a “life”.
    - When this happens, vibrate the phone using the [Vibrator](https://developer.android.com/reference/android/os/Vibrator) class, [link](https://piazza.com/class/mf8rge02pc51zf/post/161) for confirmation that this counts as "meaningful use ... [of] ... hardware (gps, accelerometer, ..) from the phone".
* Based on the amount of time elapsed from the GameTimer, the frequency of obstacle objects generated will increase (maybe GameTimer_VALUE x multiplier = n, create an obstacle object every n intervals)
* Score will be calculated by either elapsed time or obstacles dodged
* When a player loses all of their “lives”, the GameTimer stops and the score is locally stored and sent to the Game Over View screen

## Views Structure:
1. Start/GameOver Screen
   - “Landing page” when opening the app
   - Contains title of the game as well as the “Start Game” button
   - Contains Game Over and final score info screen
2. Preferences Screen
   - (Suggestions) Color Themes
   - (Suggestions) Number of Lives
   - (Suggestions) Language
3. Game Screen
   - Runs the 3 track obstacle course game

## File Setup Preliminary:
### Model:
1. Obstacles.kt
   * Array of obstacles that are on screen
2. Obstacle inner class 
   * Location X  - float
   * Location Y   -  float
   * Track  -  int
3. Player companion object  (all below in constructor)
   * Location X  - float
   * Location Y - float
   * Avatar png file name
### View:
1. MainActivity.kt
2. GameView.kt
   * Fixed track, each gets X
  * Calls Obstacles functions to access/update info on obstacle location
### Controller:
1. GameActivity.kt
