package com.stevenbenack.todoit.Storage;


public class TaskDbSchema {
    public static final class TaskTable {
        public static final String NAME = "ToDoTask";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DESCRIPTION = "description";
            public static final String CREATED = "created";
            public static final String DUE = "due";
            public static final String PRIORITY = "priority";
            public static final String DONE = "done";
        }
    }
}
