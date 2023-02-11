-- Different item categories.
INSERT INTO ITEM_CATEGORY (ITEM_CATEGORY_ID, CATEGORY_NAME, CATEGORY_DESCRIPTION) VALUES (1, 'Food', 'Replenishes your hunger.');
INSERT INTO ITEM_CATEGORY (ITEM_CATEGORY_ID, CATEGORY_NAME, CATEGORY_DESCRIPTION) VALUES (2, 'Weapon', 'Replenishes your hunger.');
INSERT INTO ITEM_CATEGORY (ITEM_CATEGORY_ID, CATEGORY_NAME, CATEGORY_DESCRIPTION) VALUES (3, 'Transportation', 'Something that assists a player in movement or in the movement of other objects.');
INSERT INTO ITEM_CATEGORY (ITEM_CATEGORY_ID, CATEGORY_NAME, CATEGORY_DESCRIPTION) VALUES (4, 'Treasure', 'Gains points towards the finish line.');
INSERT INTO ITEM_CATEGORY (ITEM_CATEGORY_ID, CATEGORY_NAME, CATEGORY_DESCRIPTION) VALUES (5, 'Navigation', 'Tools to help you find your way.');

-- Different types of food.
INSERT INTO ITEM (ITEM_ID, ITEM_NAME, ITEM_DESCRIPTION) VALUES (1, 'Mushroom', 1);
-- Walk West (Main Scenario)
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (1, 'You enter this bog but beware there are dangers like mud pits and gators. In addition you may come across a tribe but who’s to say they are friendly or not. You have entered the damp viridian bogs.', NULL, NULL);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (2, 'You have found an old tree covered in mushrooms.', NULL, NULL);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (3, 'Entering a small clearing you see two paths in front of you.', NULL, NULL);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (4, 'You have approached the edge of a large area of water.', NULL, NULL);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (5, 'As you begin swimming you hear a distant splash… You keep swimming but suddenly are pulled under by a gator. You have died.', 1, 0);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (6, 'You walk back to the clearing but a tree falls down blocking your way back to the water', NULL, NULL);
-- You have collected 3 termites and began walking down the south path. (CHOICE feedback)
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (8, 'You have entered another clearing and have noticed a weird sulfur like smell in the air but can’t locate where it’s from.', NULL, NULL);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (9, 'You have found a hot Spring spewing poisonous gas. You feel yourself fainting and you pass out. You awake in a strange home and hear people speaking a language you have never heard before outside. You notice that you have none of your equipment. And are wearing a kind of animal hide. As you glance around the room you notice some rope near the door but can’t find any trace of your former clothes. You also notice a window next to you that could be an escape route.', NULL, NULL);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (10, 'You get up and walk slowly and quietly towards the rope. However, you have not fully regained your strength and begin to stumble. You still manage to get the rope, however, in the process you made a lot of noise. The Tribal members heard this and burst in to the tent and attack you. You have died.', 1, 0);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (11, 'Suddenly the tribe members enter the home and brings you medicine. You are there for a very long time. You eventually learn their language. And that there is a tribal war and that they were nervous and on edge because of this and are glad you are a friend.', NULL, NULL);
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT, SCENARIO_IS_END, SCENARIO_PLAYER_WON) VALUES (12, 'You decide to stay with the tribe. You help them in the tribal war and get injured. However, they help you and the tribe ends up winning.', 1, 1);

INSERT INTO CHOICE (CHOICE_ID, CHOICE_TEXT, CHOICE_LEADS_TO, CHOICE_FETCHABLE_ITEM, CHOICE_USABLE_ITEM, CHOICE_FEEDBACK) VALUES (1, 'WALK NORTH', 2, NULL, NULL, NULL);
INSERT INTO CHOICE (CHOICE_ID, CHOICE_TEXT, CHOICE_LEADS_TO, CHOICE_FETCHABLE_ITEM, CHOICE_USABLE_ITEM, CHOICE_FEEDBACK) VALUES (2, 'TAKE MUSHROOM', 3, 1, NULL, 'You grab the mushrooms and continue west.');
INSERT INTO CHOICE(CHOICE_ID, CHOICE_TEXT, CHOICE_LEADS_TO, CHOICE_FETCHABLE_ITEM, CHOICE_USABLE_ITEM, CHOICE_FEEDBACK) VALUES (3, 'WALK WEST', 4, NULL, NULL, NULL);
INSERT INTO CHOICE (CHOICE_ID, CHOICE_TEXT, CHOICE_LEADS_TO, CHOICE_FETCHABLE_ITEM, CHOICE_USABLE_ITEM, CHOICE_FEEDBACK) VALUES ('You have collected 3 termites and began walking down the south path.');

INSERT INTO SCENARIO_CHOICE(SCENARIO_ID, CHOICE_ID) VALUES (1, 1);


