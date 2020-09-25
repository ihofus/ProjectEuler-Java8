package lt.oworks.projecteuler.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem54 {

    public static void main(String[] args) {
        Stream.of(
                "5H 5C 6S 7S KD 2C 3S 8S 8D TD",
                "5D 8C 9S JS AC 2C 5C 7D 8S QH",
                "2D 9C AS AH AC 3D 6D 7D TD QD",
                "4D 6S 9H QH QC 3D 6D 7H QD QS",
                "2H 2D 4C 4D 4S 3C 3D 3S 9S 9D"
        )
                .map(Problem54::runGame)
                .forEach(System.out::println);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(Problem54.class.getResourceAsStream("/54/p054_poker.txt")))) {
            System.out.println(br.lines()
                    .map(Problem54::runGame)
                    .filter(won -> won)
                    .count());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    enum Suit {
        Clubs("C"), Diamonds("D"), Hearts("H"), Spades("S");
        private final String value;

        Suit(String value) {
            this.value = value;
        }

        static Suit fromValue(final String value) {
            return Arrays.stream(Suit.values())
                    .filter(suit -> value.equals(suit.value))
                    .findFirst()
                    .get();
        }
    }

    enum Rank {
        R2(2, "2"),
        R3(3, "3"),
        R4(4, "4"),
        R5(5, "5"),
        R6(6, "6"),
        R7(7, "7"),
        R8(8, "8"),
        R9(9, "9"),
        R10(10, "T"),
        Jack(11, "J"),
        Queen(12, "Q"),
        King(13, "K"),
        Ace(14, "A");

        private final int rank;
        private final String value;

        Rank(int rank, String value) {
            this.rank = rank;
            this.value = value;
        }

        static Rank fromValue(final String value) {
            return Arrays.stream(Rank.values())
                    .filter(rank -> value.equals(rank.value))
                    .findFirst()
                    .get();
        }
    }

    static class Card implements Comparable<Card> {
        private final Suit suit;
        private final Rank rank;

        Card(Suit suit, Rank rank) {
            this.suit = suit;
            this.rank = rank;
        }

        Card(String[] coded) {
            this(Suit.fromValue(coded[1]), Rank.fromValue(coded[0]));
        }

        @Override
        public int compareTo(Card o) {
            return -(rank.rank - o.rank.rank);
        }

        @Override
        public String toString() {
            return rank.value + suit.value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Card card = (Card) o;
            return suit == card.suit &&
                    rank == card.rank;
        }

        @Override
        public int hashCode() {
            return Objects.hash(suit, rank);
        }
    }

    enum Hand {
        royalFlush(10, Problem54::royalFlush),
        straightFlush(9, Problem54::straightFlush),
        fourOfAKind(8, Problem54::fourOfAKind),
        fullHouse(7, Problem54::fullHouse),
        flush(6, Problem54::flush),
        straight(5, Problem54::straight),
        threeOfAKind(4, Problem54::threeOfAKind),
        twoPair(3, Problem54::twoPair),
        onePair(2, Problem54::onePair),
        highCard(1, Problem54::highCard);
        private final int rank;
        private final Function<List<Card>, List<Card>> hasIt;

        Hand(int rank, Function<List<Card>, List<Card>> hasIt) {
            this.rank = rank;
            this.hasIt = hasIt;
        }

        List<Card> hasIt(List<Card> cards) {
            return hasIt.apply(cards);
        }
    }

    private static List<Card> royalFlush(List<Card> cards) {
        List<Card> straight = new ArrayList<>(cards);
        Iterator<Card> iterator = straight.iterator();
        Card current = iterator.next();
        Suit suit = current.suit;
        if (!current.rank.equals(Rank.Ace)) {
            return List.of();
        }
        while (iterator.hasNext()) {
            Card next = iterator.next();
            if (current.rank.rank - next.rank.rank != 1 || !suit.equals(next.suit)) {
                return List.of();
            }
            current = next;
        }
        return straight;
    }

    private static List<Card> straightFlush(List<Card> cards) {
        List<Card> straight = new ArrayList<>(cards);
        Iterator<Card> iterator = straight.iterator();
        Card current = iterator.next();
        Suit suit = current.suit;
        while (iterator.hasNext()) {
            Card next = iterator.next();
            if (current.rank.rank - next.rank.rank != 1 || !suit.equals(next.suit)) {
                return List.of();
            }
            current = next;
        }
        return straight;
    }

    private static List<Card> fourOfAKind(List<Card> cards) {
        return cards.stream()
                .collect(Collectors.groupingBy(card -> card.rank))
                .values().stream()
                .filter(list -> list.size() == 4)
                .findFirst()
                .orElse(List.of());
    }

    private static List<Card> fullHouse(List<Card> cards) {
        final Collection<List<Card>> grouped = cards.stream()
                .collect(Collectors.groupingBy(card -> card.rank))
                .values();
        return grouped.stream()
                .anyMatch(list -> list.size() == 3)
                && grouped.stream()
                .anyMatch(list -> list.size() == 2) ?
                new ArrayList<>(cards) : List.of();
    }

    private static List<Card> flush(List<Card> cards) {
        Suit suit = cards.iterator().next().suit;
        return cards.stream().map(card -> card.suit).allMatch(suit::equals) ?
                new ArrayList<>(cards) : List.of();
    }

    private static List<Card> highCard(List<Card> cards) {
        return cards.stream()
                .limit(1)
                .collect(Collectors.toList());
    }

    private static List<Card> onePair(List<Card> cards) {
        return cards.stream()
                .collect(Collectors.groupingBy(card -> card.rank))
                .values().stream()
                .filter(list -> list.size() == 2)
                .findFirst()
                .orElse(List.of());
    }

    private static List<Card> twoPair(List<Card> cards) {
        List<Card> twoPairs = new ArrayList<>();
        cards.stream()
                .collect(Collectors.groupingBy(card -> card.rank))
                .values().stream()
                .filter(list -> list.size() == 2)
                .forEach(twoPairs::addAll);

        return twoPairs.size() == 4 ? twoPairs : List.of();
    }

    private static List<Card> threeOfAKind(List<Card> cards) {
        return cards.stream()
                .collect(Collectors.groupingBy(card -> card.rank))
                .values().stream()
                .filter(list -> list.size() == 3)
                .findFirst()
                .orElse(List.of());
    }

    private static List<Card> straight(List<Card> cards) {
        List<Card> straight = new ArrayList<>(cards);
        Iterator<Card> iterator = straight.iterator();
        Card current = iterator.next();
        while (iterator.hasNext()) {
            Card next = iterator.next();
            if (current.rank.rank - next.rank.rank != 1) {
                return List.of();
            }
            current = next;
        }
        return straight;
    }

    static boolean runGame(final String cardsInHands) {
        final List<Card> player1 = new ArrayList<>();
        final List<Card> player2 = new ArrayList<>();
        final String[] strings = cardsInHands.split(" ");
        Arrays.stream(strings)
                .limit(5)
                .map(card -> card.split(""))
                .map(Card::new)
                .forEach(player1::add);

        Arrays.stream(strings)
                .skip(5)
                .map(card -> card.split(""))
                .map(Card::new)
                .forEach(player2::add);

        Collections.sort(player1);
        Collections.sort(player2);

        return playerOneWin(player1, player2);
    }


    static boolean playerOneWin(List<Card> player1, List<Card> player2) {
        Entry hand1 = whichHand(player1);
        Entry hand2 = whichHand(player2);
        if (!hand1.hand.equals(hand2.hand)) {
            return hand1.hand.rank > hand2.hand.rank;
        }

        final Card card1 = hand1.cards.iterator().next();
        final Card card2 = hand2.cards.iterator().next();
        if (!card1.rank.equals(card2.rank)) {
            return card1.rank.rank > card2.rank.rank;
        }

        Iterator<Card> iterator1 = player1.iterator();
        Iterator<Card> iterator2 = player2.iterator();

        while (iterator1.hasNext()) {
            final Card cc1 = iterator1.next();
            final Card cc2 = iterator2.next();
            if (!cc1.rank.equals(cc2.rank)) {
                return cc1.rank.rank > cc2.rank.rank;
            }
        }
        return false;
    }

    static Entry whichHand(List<Card> player) {
        return Arrays.stream(Hand.values())
                .map(hand -> new Entry(hand, hand.hasIt(player)))
                .filter(entry -> !entry.cards.isEmpty())
                .findFirst()
                .get();

    }

    static class Entry {
        final Hand hand;
        final List<Card> cards;

        Entry(Hand hand, List<Card> cards) {
            this.hand = hand;
            this.cards = new ArrayList<>(cards);
            order(this);
        }
    }

    static void order(final Entry entry) {
        if (Hand.fullHouse.equals(entry.hand)) {
            List<Card> ordered = entry.cards.stream()
                    .collect(Collectors.groupingBy(card -> card.rank))
                    .values().stream()
                    .sorted((l1, l2) -> Integer.compare(l2.size(), l1.size()))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
            entry.cards.clear();
            entry.cards.addAll(ordered);
        } else {
            Collections.sort(entry.cards);
        }
    }
}
