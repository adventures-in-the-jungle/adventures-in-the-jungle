package io.github.adventures_in_the_jungle.logic.game;

import io.github.adventures_in_the_jungle.logic.database.objects.Item;
import io.github.adventures_in_the_jungle.logic.game.item.properties.IStorable;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class Inventory implements Comparator<Item>, Collection<IStorable> {

    private ArrayList<IStorable> items;

    public Inventory()
    {
        this.items = new ArrayList<IStorable>();
    }

    @Override
    public int compare(Item o1, Item o2) {
        return 0;
    }

    @Override
    public Comparator<Item> reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator<Item> thenComparing(Comparator<? super Item> other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    public <U> Comparator<Item> thenComparing(Function<? super Item, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Item> thenComparing(Function<? super Item, ? extends U> keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator<Item> thenComparingInt(ToIntFunction<? super Item> keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator<Item> thenComparingLong(ToLongFunction<? super Item> keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator<Item> thenComparingDouble(ToDoubleFunction<? super Item> keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }

    @Override
    public int size() {
        return this.items.size();
    }

    @Override
    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.items.contains(o);
    }

    @Override
    public Iterator<IStorable> iterator() {
        return this.items.iterator();
    }

    @Override
    public void forEach(Consumer<? super IStorable> action) {
        this.items.forEach(action);
    }

    @Override
    public Object[] toArray() {
        return this.items.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return this.items.toArray(a);
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return this.items.toArray(generator);
    }

    @Override
    public boolean add(IStorable iStorable) {
        return this.items.add(iStorable);
    }

    @Override
    public boolean remove(Object o) {
        return this.items.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.items.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends IStorable> c) {
        return this.items.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.items.removeAll(c);
    }

    @Override
    public boolean removeIf(Predicate<? super IStorable> filter) {
        return this.items.removeIf(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.items.retainAll(c);
    }

    @Override
    public void clear() {
        this.items.clear();
    }

    @Override
    public Spliterator<IStorable> spliterator() {
        return Collection.super.spliterator();
    }

    @Override
    public Stream<IStorable> stream() {
        return this.items.stream();
    }

    @Override
    public Stream<IStorable> parallelStream() {
        return this.items.parallelStream();
    }
}
