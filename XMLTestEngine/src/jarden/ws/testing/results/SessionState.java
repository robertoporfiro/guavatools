package jarden.ws.testing.results;

public enum SessionState {
    New,            // the session has been created, but no results have been passed to it yet.
    Started,        // the session now contains some results
    Finished,       // the session may contain results, and has been marked finished by the client
    Interrupted,    // the test was closed half (or even a quarter!) way through
    Orphaned        // the test moved house without telling anyone, and all its kids were left on their lonesome. (the session was not closed properly)

}
