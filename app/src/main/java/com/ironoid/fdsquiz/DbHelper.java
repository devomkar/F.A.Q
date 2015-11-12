package com.ironoid.fdsquiz;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuiz";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    private static final String KEY_OPTD= "optd";
    private SQLiteDatabase dbase;
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC +" TEXT, "+KEY_OPTD+" TEXT)";
        db.execSQL(sql);
        addQuestions();
        //db.close();
    }
    private void addQuestions()
    {
        Question q1=new Question("1.Which of the following data structure is non-linear type?",
                "Strings","Stacks", "Array", "Trees", "Trees");
        this.addQuestion(q1);
		
        Question q2=new Question("2. Which of the following data structure is linear type?"
                , "Array", "Tree", "Hierarchy", "Graphs", "Array");
        this.addQuestion(q2);
		
        Question q3=new Question("3. The logical or mathematical model of a particular organization of data is called a?"
                , " Data arrangement", "Data configuration", "Data structure", "Data formation", "Data structure");
        this.addQuestion(q3);
        
		Question q4=new Question("4. The simplest type of data structure is?"
                , "Three dimensional array", "Multidimensional array", "Linear array", "Two dimensional array", "Multidimensional array");
        this.addQuestion(q4);
        
		Question q5=new Question("5. Linear arrays are also called ..........."
                , "Straight line array", "One-dimensional array", " Horizontal array", "Vertical array", "One-dimensional array");
        this.addQuestion(q5);
        
		Question q6=new Question("6. Arrays are best data structures ............"
                , "For none of the below", "For both of below situation", "For the size of the structure and the data in the structure are constantly changing", "For relatively permanent collections of data", "For relatively permanent collections of data");
        this.addQuestion(q6);
        
		Question q7=new Question("7. Linked list are not suitable data structure of which one of the following problems ?"
                ," Binary search", "Insertion sort", "Radix sort", "Polynomial manipulation", " Binary search");
        this.addQuestion(q7);
        
		Question q8=new Question(" 8.Which of the following algorithm design technique is used in the quick sort algorithm?"
                , "Dynamic programming", "Backtracking", "Divide and conquer", "Greedy method", "Divide and conquer");
        this.addQuestion(q8);
        
		Question q9=new Question("9.The number of swapping needed to sort numbers 8,22,7,9,31,19,5,13 in ascending order using bubble sort is ? "
                , "11", "12", "13", "14", "14");
        this.addQuestion(q9);
        
		Question q10=new Question("10.Merge sort uses ?"
                , "Divide and conquer strategy", "Backtracking approach", "Heuristic search", "Greedy approach", "Divide and conquer strategy");
        this.addQuestion(q10);

        Question q11=new Question("11.Queue can be used to implement ?"
                , "heap sort", "quick sort", "merge sort", "insertion sort", "quick sort");
        this.addQuestion(q11);

        Question q12=new Question("12.Sparse matrices have ?"
                , "no zero", "higher dimenstion", "many zero", "none", "many zero");
        this.addQuestion(q12);

        Question q13=new Question("13.The memory address of the first element of an array is called?"
                , "floor address", "foundation address", "first address", "base address", "base address");
        this.addQuestion(q13);

        Question q14=new Question("14.A Alphanumeric value that does not change during execution of a program is ?"
                , "Variable", "Constant", "Symbol", "Macro", "Constant");
        this.addQuestion(q14);

        Question q15=new Question("A declaration Short int is used for variables?"
                , "Which requires faster execution", "Which have short names", "Which may require less storage than normal integers", "All of these", "All of these");
        this.addQuestion(q15);

        Question q16=new Question("The Function fprintf is used in a program....."
                , "When too many printf are already used", "fprintf uses less memory", "When the output is to be printed in a file", "Variables are to be printed", "When the output is to be printed in a file");
        this.addQuestion(q16);

        Question q17=new Question("Unary  operators are ?"
                , "-(unary minus)", "--", "++", "All of the above", "All of the above");
        this.addQuestion(q17);

        Question q18=new Question("Logical operators are?"
                , "+,-,/,%", "&&,!", "&,~", "All of the above", "&&,!");
        this.addQuestion(q18);

        Question q19=new Question("Arithmatic Operators are?"
                , "+,-,*,/", "&&,!", "&&,||,~", "All of the above", "+,-,*,/");
        this.addQuestion(q19);

        Question q20=new Question("Bitwise Operators are?"
                , "+,/,-,%", "&&,||,!", "&,|,~", "All of the above", "&,|,~");
        this.addQuestion(q20);

        Question q21=new Question("Unary operators are ________."
                , "+-*=", "*,+,-,=", "+,*,-,=", "None of the above", "=,*,-,=");
        this.addQuestion(q21);

        Question q22=new Question("When a function is recursively called, all automatic (local) variables _________."
                , "are initialized during each execution of the function", "are retained from the last execution", "are maintained in a queue", "none of these", "are initialized during each execution of the function");
        this.addQuestion(q22);

        Question q23=new Question("Advantages of using a function is _________."
                , "A large program is without function is difficult to test,debug adn update", "provides abstraction", "improves readability", "All fo the above", "All of the above");
        this.addQuestion(q23);

        Question q24=new Question("A static variable si declared _________."
                , "inside the function", "outside the body of function", "both of the above", "none of above", "both of the above");
        this.addQuestion(q24);

        Question q25=new Question("For loop in a C-program , if the condition is missing"
                , "It is assumed to be present and tajen to be false", "It is assumed to be present and taken to be true", "It results in a syntx errir", "Execution will be terminated abrupty", "It is assumed to be present and taken to be true");
        this.addQuestion(q25);

        Question q26=new Question("Which of the following data structures are indexed structures ?"
                , "Linear arrays", "Linked lists", "Both of above", "None of the above", "Linear arrays");
        this.addQuestion(q26);

        Question q27=new Question("Two dimensional arrays are also called __________."
                , "Tables arrays ", "matrix arrays", "both of above", "None of the above", "both of the above");
        this.addQuestion(q27);

        Question q28=new Question("Which of the following data structure can't store the non-homogenous data elements? "
                , "Arrays ", "Records", "Pointers", "None", "Arrays");
        this.addQuestion(q28);

        Question q29=new Question("Which of the following data structre store the homogenous data elements?"
                , "Arrays", "Records", "Pointers", "None", "Records");
        this.addQuestion(q29);

        Question q30=new Question("A variable p is called pointer if"
                , "P contains tge address of an element in DATA", "P points to the address of first element in DATA", "P can store only memory addresses", "P contains the DATA and the address of DATA", "P contains tge address of an element in DATA");
        this.addQuestion(q30);

        Question q31=new Question("The 'wb' option during opening a file _______."
                , "creates a binary file and discards previous contents", "creates a binary file and preserves contents", "create a text file", "opens an existing text file", "creates a binary file and discards previous contents");
        this.addQuestion(q31);

        Question q32=new Question("No. of bytes required to store 1234 in a binary file is "
                , "2", "3", "4", "1", "2");
        this.addQuestion(q32);

        Question q33=new Question("The command fp=fopen('file name','r')will retuen _________ if the file does not exist"
                , "1", "0", "file name", "garbage value", "0");
        this.addQuestion(q33);

        Question q34=new Question("One can find the size of file using ____"
                , "ftell() function", "fseek() function", "fseek() and ftell() function", "none of these", "fseek() and ftell() function");
        this.addQuestion(q34);

        Question q35=new Question("Efficiency of an algorithm is measured in terms of _____ and _______ complexity."
                , "time,space", "timex,data", "data,space", "processor,memory", "time,space");
        this.addQuestion(q35);

        Question q36=new Question("Time complexity of an algorithum depends upon _______"
                , "A- size the input", "B- speed of computer", "frequency count", "both A and B", "frequency count");
        this.addQuestion(q36);

        Question q37=new Question("The time factor when determining the efficiency of algorithmis measured by ______."
                , "Counting microseconds", "Counting the number of key operations", "Counting the number of statements", "Countinf the kilobytes of algorithm", "Countinf the number of key operations");
        this.addQuestion(q37);

        Question q38=new Question("The space folder when determining the efficiency of algorithm is measured by _______>"
                , "Counting the maximum memory needed by the algorithm", "Counting the minimum memory needed by the algorithm", "Counting the average memory needed by the algorithm", "Counting the maximum disk space needed by the algorithm", "Counting the maximum memory needed by the algorithm");
        this.addQuestion(q38);

        Question q39=new Question("which of the following case does not exist in complexity theory?"
                , "Best case", "Worst case", "Average case", "Null case", "Null case");
        this.addQuestion(q39);

        Question q40=new Question("What is the disadvantage of a binary search?"
                , "Fast", "Time consuming", "Need a sorted array", "Doesn't need sorted array", "Doesn't needs a sorted array");
        this.addQuestion(q40);

        Question q41=new Question("A non-recursive quick sort algorithum can be written _______."
                , "with stack ", "without a stack", "both of the above", "none of the above", "with stack");
        this.addQuestion(q41);

        Question q42=new Question("A quick sort algorithum will show its best behavior when ______."
                , "partition is near cantre", "partition is near left end of the list", "parition is near right end of the list", "all of the above", "partition is near cantre");
        this.addQuestion(q42);

        Question q43=new Question(""
                , "", "", "", "", "");
        this.addQuestion(q43);

        Question q44=new Question(""
                , "", "", "", "", "");
        this.addQuestion(q44);

        Question q45=new Question(""
                , "", "", "", "", "");
        this.addQuestion(q45);

        Question q46=new Question(""
                , "", "", "", "", "");
        this.addQuestion(q46);



    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_OPTD, quest.getOPTD());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setOPTD(cursor.getString(6));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();

        return row;
    }
}

