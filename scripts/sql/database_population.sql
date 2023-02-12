-- Different item categories.
INSERT INTO ITEM_CATEGORY (ITEM_CATEGORY_ID, CATEGORY_NAME, CATEGORY_DESCRIPTION) VALUES (1, 'Food', 'Replenishes your hunger.');
INSERT INTO ITEM_CATEGORY (ITEM_CATEGORY_ID, CATEGORY_NAME, CATEGORY_DESCRIPTION) VALUES (2, 'Weapon', 'Fights off enemies.');
INSERT INTO ITEM_CATEGORY (ITEM_CATEGORY_ID, CATEGORY_NAME, CATEGORY_DESCRIPTION) VALUES (3, 'Transportation', 'Something that assists a player in movement or in the movement of other objects.');
INSERT INTO ITEM_CATEGORY (ITEM_CATEGORY_ID, CATEGORY_NAME, CATEGORY_DESCRIPTION) VALUES (4, 'Treasure', 'Gains points towards the finish line.');
INSERT INTO ITEM_CATEGORY (ITEM_CATEGORY_ID, CATEGORY_NAME, CATEGORY_DESCRIPTION) VALUES (5, 'Navigation', 'Tools to help you find your way.');

-- Different types of food.
INSERT INTO ITEM (ITEM_ID, ITEM_NAME, ITEM_DESCRIPTION) VALUES (1, 'Mushroom', 4);
INSERT INTO ITEM (ITEM_ID, ITEM_NAME, ITEM_DESCRIPTION) VALUES (2, 'Maggots', 1);
INSERT INTO ITEM (ITEM_ID, ITEM_NAME, ITEM_DESCRIPTION) VALUES (3, 'Termites', 1);

-- Walk West (Main Scenario)
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (1, 'You enter this bog but beware there are dangers like mud pits and gators. In addition you may come across a tribe but who’s to say they are friendly or not. You have entered the damp viridian bogs.', 0, 0);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (2, 'You have found an old tree covered in mushrooms.', 0, 0);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (3, 'Entering a small clearing you see two paths in front of you.', 0, 0);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (4, 'You have approached the edge of a large area of water.', 0, 0);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (5, 'As you begin swimming you hear a distant splash… You keep swimming but suddenly are pulled under by a gator. You have died.', 1, 0);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (6, 'You walk back to the clearing but a tree falls down blocking your way back to the water', 0, 0);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (7, 'You have entered another clearing and have noticed a weird sulfur like smell in the air but can’t locate where it’s from.', 0, 0);
-- (CHOICE feedback) -this feedback is only for going west. ref to 2b in doc.
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (8, 'You awake in a strange home and hear people speaking a language you have never heard before outside. You notice that you have none of your equipment. And are wearing a kind of animal hide. As you glance around the room you notice some rope near the door but can’t find any trace of your former clothes. You also notice a window next to you that could be an escape route.', 0, 0);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (9, 'You get up and walk slowly and quietly towards the rope. However, you have not fully regained your strength and begin to stumble. You still manage to get the rope, however, in the process you made a lot of noise. The Tribal members heard this and burst in to the tent and attack you. You have died.', 1, 0);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (10, 'Suddenly the tribe members enter the home and brings you medicine. You are there for a very long time. You eventually learn their language. And that there is a tribal war and that they were nervous and on edge because of this and are glad you are a friend.', 0, 0);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (11, 'You decide to stay with the tribe. You help them in the tribal war and get injured. However, they help you and the tribe ends up winning.', 1, 1);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (12, 'Even though the tribe has done so much for you and treated you like family. You remember you have a family of your own waiting for you. You explain to the tribe that you are grateful for everything but have a family to return to. They understand and guide you to the exit of the jungle. Once you reunite with your family you can’t help but wish you had repaid the generosity of the tribe with your own.', 1, 1);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (13, 'You get up from where you’re laying and crawl through the window. Luckily no one heard you. You begin running, however you still have not recovered your strength. You can either continue running or sit and wait.', 0, 0);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (14, 'You continue running stumbling as you go, suddenly you hit a tripwire and fall off the edge of the path, tumbling down the steep hill. When you finally stop, you notice that you are near a big body of water.', 0, 0);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (15, 'You toss the animal hide you are wearing into the water, the smell draws in the nearby piranhas. This allows you to swim across. After you make it across you find a clearing and road and follow it to the nearest town.', 1, 1);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (16, 'You begin swimming across. However the animal hide you are currently wearing has a stench. This stench attracts the local piranhas within the water. You are attacked and eaten alive.', 1, 0);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (17, 'You are very tired and decide to wait next to a tree. Eventually you end up falling asleep. While sleeping a snake slithers down from the tree and bites you. The venom from the bite kills you quickly.', 1, 0);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (18, 'You begin walking down the path to the north this path has high grass but thanks to the mushroom you collected earlier, any potential threats have been deterred. You continue walking and find a corpse.', 0, 0);
-- Something has stolen all your food while you were walking through the tall grass. (CHOICE feedback)
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (19, 'You notice the corpse is of a tribal man, they have a spear in their back and are decaying.', 0, 0);
-- You took the maggots (CHOICE Feedback)
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (20, 'You have reached a cross roads. You notice that both the north and south paths are less overgrown than the eastern path.', 0, 0);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (21, 'You begin to walk east through the overgrown path. Suddenly you are falling. You have fallen into a spike pit and have died.', 1, 0);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (22, 'You have been walking for quite some distance. And are getting very hungry.', 0, 0);
-- You ate some food that you collected and have energy to continue the journey down this path. You end up finding a tribe. (CHOICE feedback)
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (23, 'The tribe does not kill you right away but is very wary of you.Eventually you gain the trust of the tribe.You even learned the language',1,1);

-- Ending Scenario without Spear Staying with the Tribe = WIN --
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (24, 'You decide to stay with the tribe. You help them in the tribal war and get injured. However they help you and the tribe ends up winning. However you miss your family. You ask the tribe if they know and could lead you out of the bog. You explain to the tribe that you are grateful for everything but have a family to return to. The tribe explains that they understand and are thankful for everything you have done for them. They guide you to the exit of the bog. Eventually you reunite with your family and explain everything. You are grateful that you were able to repay the tribe for everything.',1,1);

--Ending Scenario without Spear leaving the Tribe = WIN --
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (25, 'You explain to the tribe that you are grateful for everything but have a family to return to. They understand and guide you to the exit of the jungle. You manage to find civilization and reconnect with your family.' ,1,1);

--Ending Scenario with Spear = LOSE --  IF HAVE SPEAR DEATH
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (26, 'The tribe sees the spear you have and attacks you immediately. You have died.', 1,0);

-- Scenario to set up loop back to 2b1 --
INSERT INTO SCENARIO(SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (27, 'You continue walking without eating but a very low on energy.”', 0,0);

--Scenario walk south Dangerous Tribe
INSERT INTO SCENARIO(SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES(28, 'You have been walking for quite some distance. And are getting very hungry.”', 0,0);
-- [Choices: use food or don’t] if have no food don’t

--Scenario if you have food to eat and move on--
INSERT INTO SCENARIO(SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES(29,'You eat and have energy to continue the journey down this path. You end up finding a tribe.
', 0,0);

--Scenario under Dangerous Tribe if you collected the Spear = GOOD
INSERT INTO SCENARIO(SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES(30,'The tribe does not kill you because they notice the spear you’re carrying. This spear is from one of their own. The tribe takes you in and teaches you their language. However you notice that this tribe is not exactly very friendly.',0,0);
--[Choices: Stay with the tribe, ask how to leave the bog, Or Run away.]

--Runaway Scenario
INSERT INTO SCENARIO(SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (31,'You plot an escape from the tribe. You decide if you need to steal any supply’s to safely escape.', 0,0);
--[Choices: Take rope and leave or leave.]

--Ending Scenario Take Rope = WIN
INSERT INTO SCENARIO(SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES(32, 'You grab some rope from the tribe when no one is looking and plot to escape at night. When its night you sneak out of your hut and run east. You make it quite far but due to foliage and the lack of sunlight you fall into a mud pit. You throw the rope and it wraps up around a tree. You climb out of the mud pit. After escaping you continue walking towards a road and wave to a passing car for help. They stop and drive you to safety.',1,1);

--Ending Scenario Don't Take Rop = LOSE
INSERT INTO SCENARIO(SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES(33,'You plot to escape at night. When its night you sneak out of your hut and run east. You make it quite far but due to foliage and the lack of sunlight you fall into a mud pit. You Struggle and struggle but with no way to pull yourself out you continue to sink until you can’t breathe. You have died.',1,0);

--Ending Scenario from Scenario number 30 this is staying with the tribe or Stay and Fight in the Doc
INSERT INTO SCENARIO(SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (34, 'You decide to stay with the tribe. You help them in the tribal war and get injured. This injury ends up being the death you.', 1,0);

--Ending Scenario from Scenario number 30 this is asking for a way out of the bog
INSERT INTO SCENARIO(SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (35, 'You ask the Tribe if they can guide you out of the bog. The tribe is not happy about this question. You explain to the tribe that you are grateful for everything but have a family to return to. The Tribe says that it is your family now. You explain that you consider them family as well. However, this is not enough, they now consider you an enemy, a traitor and attack you. You have died.',1,0);

--Ending Scenario from initial meet up with Dangerous Tribe this is if you don't have Spear
INSERT INTO SCENARIO(SCENARIO_ID, SCENARIO_TEXT,SCENARIO_IS_END,SCENARIO_PLAYER_WON) VALUES(36, 'The tribe immediately kills you on site. You have died.',1,0);

--Ending Scenario from initial meet up with Dangerous Tribe if you dont have food to eat
INSERT INTO SCENARIO(SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES(37,'You continue walking without eating but a very low on energy. Eventually you collapse and die.',1,0);

--Ending Scenario from initial path to be chosen this is WALK SOUTH
INSERT INTO SCENARIO(SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES(38,'You feel an unwelcomed gaze upon you… Suddenly a spear is flung at you hitting you directly in the heart and killing you.',1,0);

-- Walk South
INSERT INTO CHOICE (CHOICE_ID, CHOICE_TEXT, CHOICE_LEADS_TO, CHOICE_FETCHABLE_ITEM, CHOICE_USABLE_ITEM, CHOICE_FEEDBACK) VALUES (1, 'WALK NORTH', 2, NULL, NULL, NULL);
INSERT INTO CHOICE (CHOICE_ID, CHOICE_TEXT, CHOICE_LEADS_TO, CHOICE_FETCHABLE_ITEM, CHOICE_USABLE_ITEM, CHOICE_FEEDBACK) VALUES (2, 'TAKE MUSHROOM', 3, 1, NULL, 'You grab the mushrooms and continue west.');
INSERT INTO CHOICE (CHOICE_ID, CHOICE_TEXT, CHOICE_LEADS_TO, CHOICE_FETCHABLE_ITEM, CHOICE_USABLE_ITEM, CHOICE_FEEDBACK) VALUES (3, 'WALK WEST', 4, NULL, NULL, NULL);
INSERT INTO CHOICE (CHOICE_ID, CHOICE_TEXT, CHOICE_LEADS_TO, CHOICE_FETCHABLE_ITEM, CHOICE_USABLE_ITEM, CHOICE_FEEDBACK) VALUES (4, 'SWIM ACROSS', 5, NULL, NULL, NULL);
INSERT INTO CHOICE (CHOICE_ID, CHOICE_TEXT, CHOICE_LEADS_TO, CHOICE_FETCHABLE_ITEM, CHOICE_USABLE_ITEM, CHOICE_FEEDBACK) VALUES (5, 'TURN BACK', 6, NULL, NULL, NULL);
INSERT INTO CHOICE (CHOICE_ID, CHOICE_TEXT, CHOICE_LEADS_TO, CHOICE_FETCHABLE_ITEM, CHOICE_USABLE_ITEM, CHOICE_FEEDBACK) VALUES (6, 'INSPECT FALLEN TREE', 7, 3, NULL, 'You collected the termites and began walking down the south path.');
INSERT INTO CHOICE (CHOICE_ID, CHOICE_TEXT, CHOICE_LEADS_TO, CHOICE_FETCHABLE_ITEM, CHOICE_USABLE_ITEM, CHOICE_FEEDBACK) VALUES (7, 'WALK SOUTH', 7, NULL, NULL, NULL);
INSERT INTO CHOICE (CHOICE_ID, CHOICE_TEXT, CHOICE_LEADS_TO, CHOICE_FETCHABLE_ITEM, CHOICE_USABLE_ITEM, CHOICE_FEEDBACK) VALUES (8, 'WALK WEST', 8, NULL, NULL, 'You have found a hot Spring spewing poisonous gas.');
INSERT INTO CHOICE (CHOICE_ID, CHOICE_TEXT, CHOICE_LEADS_TO, CHOICE_FETCHABLE_ITEM, CHOICE_USABLE_ITEM, CHOICE_FEEDBACK) VALUES (9, 'WALK EAST', 18, NULL, NULL, NULL);
INSERT INTO CHOICE (CHOICE_ID, CHOICE_TEXT, CHOICE_LEADS_TO, CHOICE_FETCHABLE_ITEM, CHOICE_USABLE_ITEM, CHOICE_FEEDBACK) VALUES (10, 'WALK SOUTH', 38, NULL, NULL, NULL);


INSERT INTO SCENARIO_CHOICE(SCENARIO_ID, CHOICE_ID) VALUES (1, 1);
