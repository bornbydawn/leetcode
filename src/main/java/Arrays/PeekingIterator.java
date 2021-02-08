package Arrays;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    Integer popped = null;
    Iterator<Integer> iterator;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.iterator = iterator;
        if(iterator.hasNext()) popped = iterator.next();
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return popped;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer toReturn = popped;
        popped = null;
        if(iterator.hasNext()) popped = iterator.next();
        return toReturn;
	}
	
	@Override
	public boolean hasNext() {
	    return popped != null;
	}
}