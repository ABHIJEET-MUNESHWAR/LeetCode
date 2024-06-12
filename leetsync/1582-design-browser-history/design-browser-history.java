class BrowserHistory {
    private Deque<String> history = new ArrayDeque<>(); // Stack to store past pages
    private Deque<String> future; // Stack to store future pages

    // Constructor that takes the starting page URL and adds it to the history
    public BrowserHistory(String homepage) {
        visit(homepage);
    }

    // Adds a new page to the history and clears the future stack
    public void visit(String url) {
        history.push(url);
        future = new ArrayDeque<>();
    }

    // Moves the user back a certain number of pages in the history
    public String back(int steps) {
        while (history.size() > 1 && steps-- > 0)
            future.push(history.pop()); // Move pages from history to future stack
        return history.peek(); // Return the current page after navigation
    }

    // Moves the user forward a certain number of pages in the future
    public String forward(int steps) {
        while (!future.isEmpty() && steps-- > 0)
            history.push(future.pop()); // Move pages from future to history stack
        return history.peek(); // Return the current page after navigation
    }
}