-- Different item categories.
INSERT INTO ITEM_CATEGORY (ITEM_CATEGORY_ID, CATEGORY_NAME, CATEGORY_DESCRIPTION) VALUES (1, 'Food', 'Replenishes your hunger.');
INSERT INTO ITEM_CATEGORY (ITEM_CATEGORY_ID, CATEGORY_NAME, CATEGORY_DESCRIPTION) VALUES (2, 'Weapon', 'Replenishes your hunger.');
INSERT INTO ITEM_CATEGORY (ITEM_CATEGORY_ID, CATEGORY_NAME, CATEGORY_DESCRIPTION) VALUES (3, 'Transportation', 'Something that assists a player in movement or in the movement of other objects.');
INSERT INTO ITEM_CATEGORY (ITEM_CATEGORY_ID, CATEGORY_NAME, CATEGORY_DESCRIPTION) VALUES (4, 'Treasure', 'Gains points towards the finish line.');
INSERT INTO ITEM_CATEGORY (ITEM_CATEGORY_ID, CATEGORY_NAME, CATEGORY_DESCRIPTION) VALUES (5, 'Navigation', 'Tools to help you find your way.');

-- Different types of food.
INSERT INTO ITEM (ITEM_ID, ITEM_NAME, ITEM_DESCRIPTION) VALUES (1, 'Mushroom', 1);

-- Walk West (Main Scenario)
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT) VALUES (1, 'You enter this bog but beware there are dangers like mud pits and gators. In addition you may come across a tribe but who’s to say they are friendly or not. You have entered the damp viridian bogs.');

-- Walk West - Path 1 - WALK NORTH
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT) VALUES (2, 'You have found an old tree covered in mushrooms.');
INSERT INTO CHOICE (CHOICE_ID, CHOICE_TEXT, CHOICE_LEADS_TO, CHOICE_FETCHABLE_ITEM, CHOICE_USABLE_ITEM) VALUES (1, 'WALK NORTH', 2, NULL, NULL);
INSERT INTO CHOICE (CHOICE_ID, CHOICE_TEXT, CHOICE_LEADS_TO, CHOICE_FETCHABLE_ITEM, CHOICE_USABLE_ITEM) VALUES (2, 'TAKE MUSHROOM', 3, 1);

INSERT INTO SCENARIO_CHOICE(SCENARIO_ID, CHOICE_ID) VALUES (1, 1);

INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT) VALUES (3, 'You grab the mushrooms and continue west.');

INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT) VALUES (4, 'Entering a small clearing you see two paths in front of you.');
INSERT INTO CHOICE(CHOICE_ID, CHOICE_TEXT, CHOICE_LEADS_TO, CHOICE_FETCHABLE_ITEM, CHOICE_USABLE_ITEM) VALUES (2, 'TAKE MUSHROOMS', 3, 1, NULL);
INSERT INTO CHOICE(CHOICE_ID, CHOICE_TEXT, CHOICE_LEADS_TO, CHOICE_FETCHABLE_ITEM, CHOICE_USABLE_ITEM) VALUES (3, 'WALK WEST', 4, NULL, NULL);

-- INSERT INTO SCENARIO_CHOICE(SCENARIO_ID, CHOICE_ID) VALUES (1,)

INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT) VALUES (6, 'You have approached the edge of a large area of water.');
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT) VALUES (7, 'As you begin swimming you hear a distant splash… You keep swimming but suddenly are pulled under by a gator. You have died.');
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT) VALUES (8, 'You walk back to the clearing but a tree falls down blocking your way back to the water');
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT) VALUES (9, 'You have collected 3 termites and began walking down the south path.');
INSERT INTO SCENARIO (SCENARIO_ID, SCENARIO_TEXT) VALUES (10, 'You have entered another clearing and have noticed a weird sulfur like smell in the air but can’t locate where it’s from.');
