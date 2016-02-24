package com.example;


import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;


public class greendaogenerator {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "com.android.cc.cc_android.greendao");
        addNote(schema);
        new DaoGenerator().generateAll(schema, "E:\\fun_workspace\\ccgj_android_sample\\app\\src\\main\\java-gen");
    }

    private static void addNote(Schema schema) {
        Entity note = schema.addEntity("Note");
        note.implementsSerializable();
        note.addIdProperty();
        note.addStringProperty("text").notNull();
        note.addStringProperty("comment");
        note.addDateProperty("date");
    }
}
