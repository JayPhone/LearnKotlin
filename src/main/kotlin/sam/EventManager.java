package sam;

import java.util.HashSet;

import sun.nio.ch.Util;

public class EventManager {
    interface OnEventListener {
        void onEvent(int event);
    }

    private HashSet<OnEventListener> onEventListeners = new HashSet<>();

    public void removeOnEventListeners(OnEventListener onEventListener) {
        this.onEventListeners.remove(onEventListener);
    }

    public void addOnEventListeners(OnEventListener onEventListeners) {
        this.onEventListeners.add(onEventListeners);
    }

    public int getListeners() {
        return onEventListeners.size();
    }
}
