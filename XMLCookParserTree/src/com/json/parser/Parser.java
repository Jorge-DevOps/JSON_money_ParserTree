package com.json.parser;

import com.json.lexer.ParserException;
import com.json.lexer.Token;
import com.json.tree.HTMLNode;
import com.json.tree.TagAttribute;

import java.util.ArrayList;
import java.util.LinkedList;

public class Parser {

	private LinkedList<Token> tokens;
	private Token lookahead;

	public HTMLNode parse(LinkedList<Token> tokens) {
		this.tokens = (LinkedList<Token>) tokens.clone();
		lookahead = tokens.getFirst();

		HTMLNode html = document();

		if (lookahead.token != Token.EPSILON) {
			throw new ParserException("Unexpected symbol " + lookahead + " found");
		}

		return html;
	}

	private void nextToken() {
		// System.out.println("Proximo: " + tokens.getFirst().sequence);
		tokens.pop();

		if (tokens.isEmpty()) {
			lookahead = new Token(Token.EPSILON, "", -1);
		} else {
			lookahead = tokens.getFirst();
		}
	}

	private HTMLNode document() {
		HTMLNode html = new HTMLNode("HTML", "", null);
		Brackets();
		return html;
	}

	private void Brackets() {
		if (lookahead.token == Token.JSON_OPEN_BRACE_BRACKETS) {
			nextToken();
			money_name();
			creator();
			currencies_symbol();
			countries_availability();
			coins_denominations();
			bills_denominations();
		} else {
			throw new ParserException("Unexpected symbol " + lookahead + " found");
		}
		if (lookahead.token == Token.COMA) {
			nextToken();
		} else {
			throw new ParserException("Unexpected symbol " + lookahead + " found");
		}
	}

	private void money_name() {
		if (lookahead.token == Token.COMILLA) {
			nextToken();
			if (lookahead.token == Token.JSON_MONEYNAME) {
				nextToken();
				if (lookahead.token == Token.COMILLA) {
					nextToken();
					if (lookahead.token == Token.EQUALS) {
						nextToken();
						if (lookahead.token == Token.COMILLA) {
							nextToken();
							if (lookahead.token == Token.FREE_TEXT) {
								nextToken();
								if (lookahead.token == Token.COMILLA) {
									nextToken();
									if (lookahead.token == Token.COMA) {
										nextToken();
									} else {
										throw new ParserException("Unexpected symbol " + lookahead + " found");
									}
								} else {
									throw new ParserException("Unexpected symbol " + lookahead + " found");
								}
							} else {
								throw new ParserException("Unexpected symbol " + lookahead + " found");
							}
						} else {
							throw new ParserException("Unexpected symbol " + lookahead + " found");
						}
					} else {
						throw new ParserException("Unexpected symbol " + lookahead + " found");
					}
				} else {
					throw new ParserException("Unexpected symbol " + lookahead + " found");
				}
			} else {
				throw new ParserException("Unexpected symbol " + lookahead + " found");
			}
		} else {
			throw new ParserException("Unexpected symbol " + lookahead + " found");
		}

	}

	private void creator() {
		if (lookahead.token == Token.COMILLA) {
			nextToken();
			if (lookahead.token == Token.JSON_MONEYNAME) {
				nextToken();
				if (lookahead.token == Token.COMILLA) {
					nextToken();
					if (lookahead.token == Token.EQUALS) {
						nextToken();
						if (lookahead.token == Token.COMILLA) {
							nextToken();
							if (lookahead.token == Token.FREE_TEXT) {
								nextToken();
								if (lookahead.token == Token.COMILLA) {
									nextToken();
									if (lookahead.token == Token.COMA) {
										nextToken();
									} else {
										throw new ParserException("Unexpected symbol " + lookahead + " found");
									}
								} else {
									throw new ParserException("Unexpected symbol " + lookahead + " found");
								}
							} else {
								throw new ParserException("Unexpected symbol " + lookahead + " found");
							}
						} else {
							throw new ParserException("Unexpected symbol " + lookahead + " found");
						}
					} else {
						throw new ParserException("Unexpected symbol " + lookahead + " found");
					}
				} else {
					throw new ParserException("Unexpected symbol " + lookahead + " found");
				}
			} else {
				throw new ParserException("Unexpected symbol " + lookahead + " found");
			}
		} else {
			throw new ParserException("Unexpected symbol " + lookahead + " found");
		}
	}

	private void currencies_symbol() {
		if (lookahead.token == Token.COMILLA) {
			nextToken();
			if (lookahead.token == Token.JSON_MONEYNAME) {
				nextToken();
				if (lookahead.token == Token.COMILLA) {
					nextToken();
					if (lookahead.token == Token.EQUALS) {
						nextToken();
						if (lookahead.token == Token.COMILLA) {
							nextToken();
							if (lookahead.token == Token.FREE_TEXT) {
								nextToken();
								if (lookahead.token == Token.COMILLA) {
									nextToken();
									if (lookahead.token == Token.COMA) {
										nextToken();
									} else {
										throw new ParserException("Unexpected symbol " + lookahead + " found");
									}
								} else {
									throw new ParserException("Unexpected symbol " + lookahead + " found");
								}
							} else {
								throw new ParserException("Unexpected symbol " + lookahead + " found");
							}
						} else {
							throw new ParserException("Unexpected symbol " + lookahead + " found");
						}
					} else {
						throw new ParserException("Unexpected symbol " + lookahead + " found");
					}
				} else {
					throw new ParserException("Unexpected symbol " + lookahead + " found");
				}
			} else {
				throw new ParserException("Unexpected symbol " + lookahead + " found");
			}
		} else {
			throw new ParserException("Unexpected symbol " + lookahead + " found");
		}
	}

	private void countries_availability() {
	}

	private void coins_denominations() {
	}

	private void bills_denominations() {
	}
	
	/*

	private void versionParam() {
		if (lookahead.token == Token.XML_VERSION_ATT) {
			nextToken();
			if (lookahead.token == Token.EQUALS) {
				nextToken();
				if (lookahead.token == Token.APOSTROPHE) {
					nextToken();
					if (lookahead.token == Token.XML_VERSION_VAL) {
						nextToken();
					} else {
						throw new ParserException("Bad XML Version");
					}
					if (lookahead.token == Token.APOSTROPHE) {
						nextToken();
					} else {
						throw new ParserException("Unexpected symbol " + lookahead + " found");
					}
				} else {
					throw new ParserException("Unexpected symbol " + lookahead + " found");
				}
			} else {
				throw new ParserException("Unexpected symbol " + lookahead + " found");
			}
		} else {
			throw new ParserException("Unexpected XML Version");
		}
	}

	private void encodingParam() {
		if (lookahead.token == Token.XML_ENCODING_ATT) {
			nextToken();
			if (lookahead.token == Token.EQUALS) {
				nextToken();
				if (lookahead.token == Token.APOSTROPHE) {
					nextToken();
					if (lookahead.token == Token.XML_ENCODING_VAL) {
						nextToken();
					} else {
						throw new ParserException("Bad XML Encoding");
					}
					if (lookahead.token == Token.APOSTROPHE) {
						nextToken();
					} else {
						throw new ParserException("Unexpected symbol " + lookahead + " found");
					}
				} else {
					throw new ParserException("Unexpected symbol " + lookahead + " found");
				}
			} else {
				throw new ParserException("Unexpected symbol " + lookahead + " found");
			}
		} else {
			throw new ParserException("Unexpected XML Encoding");
		}
	}

	private void cookingTag(HTMLNode node) {
		if (lookahead.token == Token.COOKING_OPEN_TAG) {
			nextToken();
			cookElements(node);
		} else {
			throw new ParserException("Unexpected symbol " + lookahead + " found");
		}
		if (lookahead.token == Token.COOKING_CLOSE_TAG) {
			nextToken();
		} else {
			throw new ParserException("Unexpected symbol " + lookahead + " found");
		}
	}

	private void cookElements(HTMLNode node) {
		HTMLNode head_tag = new HTMLNode("HEAD", "", null);
		head_tag.addChild(nameTag());
		node.addChild(head_tag);

		HTMLNode body_tag = new HTMLNode("BODY", "", null);
		body_tag.addChild(utensilsTag());
		body_tag.addChild(ingredientsTag());
		body_tag.addChild(processTag());
		node.addChild(body_tag);
	}

	private HTMLNode nameTag() {
		HTMLNode name_tag = null;
		String text;
		if (lookahead.token == Token.NAME_OPEN_TAG) {
			nextToken();
		} else {
			throw new ParserException("Unexpected <name> tag.");
		}
		if (lookahead.token == Token.FREE_TEXT) {
			text = lookahead.sequence;
			nextToken();
		} else {
			throw new ParserException("Unexpected text <name> tag.");
		}
		if (lookahead.token == Token.NAME_CLOSE_TAG) {
			nextToken();
			name_tag = new HTMLNode("TITLE", text, null);
		} else {
			throw new ParserException("Unexpected close <name> tag.");
		}
		return name_tag;
	}

	private HTMLNode utensilsTag() {
		TagAttribute ta = new TagAttribute("border", "1");
		ArrayList<TagAttribute> ta_arr = new ArrayList<>();
		ta_arr.add(ta);
		HTMLNode utensils_tag = new HTMLNode("TABLE", "", ta_arr);
		if (lookahead.token == Token.UTENSILS_OPEN_TAG) {
			nextToken();
			utensils(utensils_tag);
		} else {
			throw new ParserException("Unexpected <utensils> tag.");
		}
		if (lookahead.token == Token.UTENSILS_CLOSE_TAG) {
			nextToken();
		} else {
			throw new ParserException("Unexpected close <utencils> tag.");
		}
		return utensils_tag;
	}

	private void utensils(HTMLNode table_node) {
		table_node.addChild(utensilTag());
		if (lookahead.token == Token.UTENSIL_OPEN_TAG) {
			utensils(table_node);
		}
	}

	private HTMLNode utensilTag() {
		HTMLNode tr = new HTMLNode("TR", "", null);
		String text = "";
		if (lookahead.token == Token.UTENSIL_OPEN_TAG) {
			nextToken();
		} else {
			throw new ParserException("Unexpected <utensil> tag.");
		}
		if (lookahead.token == Token.FREE_TEXT) {
			text = lookahead.sequence;
			nextToken();
		} else {
			throw new ParserException("Unexpected text <utensil> tag.");
		}
		if (lookahead.token == Token.UTENSIL_CLOSE_TAG) {
			HTMLNode td = new HTMLNode("TD", text, null);
			tr.addChild(td);
			nextToken();
		} else {
			throw new ParserException("Unexpected close <utensil> tag.");
		}
		return tr;
	}

	private HTMLNode ingredientsTag() {
		TagAttribute ta = new TagAttribute("border", "1");
		ArrayList<TagAttribute> ta_arr = new ArrayList<>();
		ta_arr.add(ta);
		HTMLNode ingredients_tag = new HTMLNode("TABLE", "", ta_arr);
		if (lookahead.token == Token.INGREDIENTS_OPEN_TAG) {
			nextToken();
			ingredients(ingredients_tag);
		} else {
			throw new ParserException("Unexpected <ingredients> tag.");
		}
		if (lookahead.token == Token.INGREDIENTS_CLOSE_TAG) {
			nextToken();
		} else {
			throw new ParserException("Unexpected close <ingredients> tag.");
		}

		return ingredients_tag;
	}

	private void ingredients(HTMLNode table_node) {
		table_node.addChild(ingredientTag());
		if (lookahead.token == Token.INGREDIENT_OPEN_TAG) {
			ingredients(table_node);
		}
	}

	private HTMLNode ingredientTag() {
		HTMLNode tr = new HTMLNode("TR", "", null);
		HTMLNode td;
		String text = "";
		if (lookahead.token == Token.INGREDIENT_OPEN_TAG) {
			nextToken();
			ingredientParams(tr);
		} else {
			throw new ParserException("Unexpected symbol " + lookahead + " found");
		}
		if (lookahead.token == Token.CLOSE_BRACKET) {
			nextToken();
		} else {
			throw new ParserException("Unexpected symbol " + lookahead + " found");
		}
		if (lookahead.token == Token.FREE_TEXT) {
			text = lookahead.sequence;
			nextToken();
		} else {
			throw new ParserException("Unexpected text <ingredient> tag.");
		}
		if (lookahead.token == Token.INGREDIENT_CLOSE_TAG) {
			td = new HTMLNode("TD", text, null);
			tr.addChild(td);
			nextToken();
		} else {
			throw new ParserException("Unexpected symbol " + lookahead + " found");
		}
		return tr;
	}

	private void ingredientParams(HTMLNode table_row) {
		table_row.addChild(amountParam());
		table_row.addChild(unitParam());
	}

	private HTMLNode amountParam() {
		HTMLNode td;
		String text;
		if (lookahead.token == Token.INGREDIENT_AMOUNT_ATT) {
			nextToken();
			if (lookahead.token == Token.EQUALS) {
				nextToken();
				if (lookahead.token == Token.APOSTROPHE) {
					nextToken();
					if (lookahead.token == Token.NUMBER) {
						text = lookahead.sequence;
						nextToken();
					} else {
						throw new ParserException("Ingredient Amount Is Not a Number");
					}
					if (lookahead.token == Token.APOSTROPHE) {
						td = new HTMLNode("TD", text, null);
						nextToken();
					} else {
						throw new ParserException("Unexpected symbol " + lookahead + " found");
					}
				} else {
					throw new ParserException("Unexpected symbol " + lookahead + " found");
				}
			} else {
				throw new ParserException("Unexpected symbol " + lookahead + " found");
			}
		} else {
			throw new ParserException("Unexpected Ingredient Amount");
		}
		return td;
	}

	private HTMLNode unitParam() {
		HTMLNode td;
		String text;
		if (lookahead.token == Token.INGREDIENT_UNIT_ATT) {
			nextToken();
			if (lookahead.token == Token.EQUALS) {
				nextToken();
				if (lookahead.token == Token.APOSTROPHE) {
					nextToken();
					if (lookahead.token == Token.UNIT) {
						text = lookahead.sequence;
						nextToken();
					} else {
						throw new ParserException("Ingredient Unit Is Not Valid");
					}
					if (lookahead.token == Token.APOSTROPHE) {
						td = new HTMLNode("TD", text, null);
						nextToken();
					} else {
						throw new ParserException("Unexpected symbol " + lookahead + " found");
					}
				} else {
					throw new ParserException("Unexpected symbol " + lookahead + " found");
				}
			} else {
				throw new ParserException("Unexpected symbol " + lookahead + " found");
			}
		} else {
			throw new ParserException("Unexpected Ingredient Unit");
		}
		return td;
	}

	private HTMLNode processTag() {
		TagAttribute ta = new TagAttribute("border", "1");
		ArrayList<TagAttribute> ta_arr = new ArrayList<>();
		ta_arr.add(ta);
		HTMLNode process_tag = new HTMLNode("TABLE", "", ta_arr);

		if (lookahead.token == Token.PROCESS_OPEN_TAG) {
			nextToken();
			steps(process_tag);
		} else {
			throw new ParserException("Unexpected <process> tag.");
		}
		if (lookahead.token == Token.PROCESS_CLOSE_TAG) {
			nextToken();
		} else {
			throw new ParserException("Unexpected close <process> tag.");
		}

		return process_tag;
	}

	private void steps(HTMLNode table_node) {
		table_node.addChild(stepTag());
		;
		if (lookahead.token == Token.STEP_OPEN_TAG) {
			steps(table_node);
		}
	}

	private HTMLNode stepTag() {
		HTMLNode tr = new HTMLNode("TR", "", null);
		HTMLNode td;
		String text = "";

		if (lookahead.token == Token.STEP_OPEN_TAG) {
			nextToken();
			stepParams(tr);
		} else {
			throw new ParserException("Unexpected symbol " + lookahead + " found");
		}
		if (lookahead.token == Token.CLOSE_BRACKET) {
			nextToken();
		} else {
			throw new ParserException("Unexpected symbol " + lookahead + " found");
		}
		if (lookahead.token == Token.FREE_TEXT) {
			text = lookahead.sequence;
			nextToken();
		} else {
			throw new ParserException("Unexpected text <step> tag.");
		}
		if (lookahead.token == Token.STEP_CLOSE_TAG) {
			td = new HTMLNode("TD", text, null);
			tr.addChild(td);
			nextToken();
		} else {
			throw new ParserException("Unexpected symbol " + lookahead + " found");
		}
		return tr;
	}

	private void stepParams(HTMLNode table_row) {
		table_row.addChild(orderParam());
		table_row.addChild(timeParam());
	}

	private HTMLNode orderParam() {
		HTMLNode td;
		String text;
		if (lookahead.token == Token.STEP_ORDER_ATT) {
			nextToken();
			if (lookahead.token == Token.EQUALS) {
				nextToken();
				if (lookahead.token == Token.APOSTROPHE) {
					nextToken();
					if (lookahead.token == Token.NUMBER) {
						text = lookahead.sequence;
						nextToken();
					} else {
						throw new ParserException("Step Order Is Not a Number.");
					}
					if (lookahead.token == Token.APOSTROPHE) {
						td = new HTMLNode("TD", text, null);
						nextToken();
					} else {
						throw new ParserException("Unexpected symbol " + lookahead + " found");
					}
				} else {
					throw new ParserException("Unexpected symbol " + lookahead + " found");
				}
			} else {
				throw new ParserException("Unexpected symbol " + lookahead + " found");
			}
		} else {
			throw new ParserException("Unexpected Ingredient Unit");
		}
		return td;
	}

	private HTMLNode timeParam() {
		HTMLNode td;
		String text;
		if (lookahead.token == Token.STEP_TIME_ATT) {
			nextToken();
			if (lookahead.token == Token.EQUALS) {
				nextToken();
				if (lookahead.token == Token.APOSTROPHE) {
					nextToken();
					if (lookahead.token == Token.NUMBER) {
						text = lookahead.sequence;
						nextToken();
					} else {
						throw new ParserException("Step Time Is Not Valid");
					}
					if (lookahead.token == Token.APOSTROPHE) {
						td = new HTMLNode("TD", text, null);
						nextToken();
					} else {
						throw new ParserException("Unexpected symbol " + lookahead + " found");
					}
				} else {
					throw new ParserException("Unexpected symbol " + lookahead + " found");
				}
			} else {
				throw new ParserException("Unexpected symbol " + lookahead + " found");
			}
		} else {
			throw new ParserException("Unexpected Ingredient Unit");
		}
		return td;
	}
*/
}
