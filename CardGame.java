public class CardGame {

    private Card[] cards;
    // create a 2D array where
    String[] types = {"Hearts", "Spade", "Diamong", "Clubs"};
    String[] ranks = {"TWO",
            "THREE",
            "FOUR",
           " FIVE",
            "SIX",
            "SEVEN",
            "EIGHT",
            "NINE",
            "TEN",
            "JACK",
            "QUEEN",
            "KING",
            "ACE"};


    public enum suites {Hearts, Spade, Diamond, Clubs};
    public enum faces { TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, ACE};




    /* Using String arrays*/
    private class Card{
        private String type;
        private String rank;

        public Card(String suite, String rank){
            this.type = suite;
            this.rank = rank;

        }
    }

    /*
   Using enum
   If used enum the values are static and final and type safe
     * each field of an enum is an instance of the Constants enum class.
      * each enum field that we create will be at least as much as the overhead of creaating an object in the JVM*/
    private class CardEnum{
        private suites s ;
        private faces f;


        private CardEnum( suites s, faces f){
            this.s = s;
            this.f = f;
        }
    }
    public void createDeckFromEnum(){
        for(suites s: suites.values()){
            for(faces f: faces.values()){
                CardEnum c = new CardEnum(s, f);
            }
        }

    }

    public void createCardDeck() {
        cards = new Card[52];
        for (int i = 0; i < types.length; i++){

            for(int j = 0; j < ranks.length; j++){
                // card 0 - j-1 will be of type[0]
                // cards j - 2*j  will be of type[1]
                // cards 2J - 3J will be of type[2]
                // convert i j into 52 nums
/*
                cards[0] = i0 * j0
                cards[1] = i0 * j1
                cards[2] - i0 * j2

                cards[13] = row* i + j
                3i + j


                */
                System.out.println(types[i] + ",  " +  ranks[j]);
                //cards[c] = new Card(types[i], ranks[j]);

            }
        }
    }

    public static void main(String[] args){
        CardGame game = new CardGame();
        game.createCardDeck();
    }

}
