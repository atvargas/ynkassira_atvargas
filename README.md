# ynkassira_atvargas
Robocode - "Deathstroke"

Initial Design/Purpose:
Originally, Deathstroke had a few objectives in predevelopment.  Overall, the goal for this Robocode was to take out the competition and win.  With that came some of its features in initial design.  It would have the ability to constantly keep moving back and forth so that, even if tracked by other Robocode, it would still be able to dodge the bullets quickly and still be within the same vicinity.  While constantly moving, Deathstroke would track enemy targets, and fire away every so often.  Based on how close the target was would determine the amount of energy used in the bullet.  A method would also be designed so that whenever Deathstroke ran into walls, it would reverse direction and get away from it, so it would not lose health.  And, if it achieved victory, a celebratory victory dance was commenced.

Our Design:
We were able to follow our initial design of our Deathstroke robot when it came to the
movements that we wanted it to make. We had the robot track and ram other robots and continue
shooting. However, we could not fulfill our hopes of a kamikaze attack on the other robots. It
seems like that isn’t a function within the game itself, so we had to change our approach. We
wanted to take inspiration from the sample ‘Crazy’ robots movement, which goes left to right
consistently. However, we had a bit of twist on that. Instead of the robot moving at a consistent
amount every fight, we used random number generators to determine our robots movement. This
would add an element of randomness to our robot that we believed would work out in battle.
That was true to an extent, but the fact that our movement was random, also meant that our robot
was better or worse on different battles. Every time the robot looped through the run method,
there were times that our robot really moved well in battle, and then there were others where the
robot just wouldn’t move.


API:
• setColors()
• setBulletColor()
• setAdjustGunForRobotTurn()
Movements:
	• ahead()
	• turnRight()
	• back()
	• turnGunRight()
• fire()
• getBearing()
• getDistance()
• scan()
• getName()
• normalRelativeAngleDegrees()
• getHeading()
• getRadarHeading()
