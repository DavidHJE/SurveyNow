package com.example.surveynow.model;

import org.junit.Test;

import static org.junit.Assert.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class FormTest {

    @Test
    public void isValid_isCorrect() {
        Form form = new Form();
        form.setName("Formulaire");
        form.setDescription("Une petit description");
        form.setAuthor("Bob");
        form.setCreatedAt(Calendar.getInstance().getTime());

        assertTrue(form.isValid());
    }

    @Test
    public void isValid_FormHasNotValue() {
        Form form = new Form();

        assertFalse(form.isValid());
    }

    @Test
    public void isValid_FormHasEmptyValue() {
        Form form = new Form();
        form.setName("");
        form.setDescription("");
        form.setAuthor("");
        form.setCreatedAt(Calendar.getInstance().getTime());

        assertFalse(form.isValid());
    }

    @Test
    public void isValid_FormHasMaxLimitDescription() {
        Form form = new Form();
        form.setName("Formulaire");
        // 375 characters
        form.setDescription("Eat owner's food. Lick yarn hanging out of own butt thug cat poop on floor and watch human clean up cattt catt cattty cat being a cat yet lick face hiss at owner, pee a lot, and meow repeatedly scratch at fence purrrrrr eat muffins and poutine until owner comes back for bite nose of your human so spill litter box, scratch at owner, destroy all furniture, especially couch. ");
        form.setAuthor("Cat Anonymize");
        form.setCreatedAt(Calendar.getInstance().getTime());

        assertFalse(form.isValid());
    }

    @Test
    public void isValid_FormHasMaxLimitAuthor() {
        Form form = new Form();
        form.setName("Formulaire");
        form.setDescription("Eat owner's food.pill litter box, scratch at owner, destroy all furniture, especially couch. ");
        // characters 119
        form.setAuthor("Mauris molestie ligula dolor, eu porttitor velit semper ut. Sed fringilla hendrerit erat, et dapibus erat blandit nec");
        form.setCreatedAt(Calendar.getInstance().getTime());

        assertFalse(form.isValid());
    }

    @Test
    public void isValid_FormHasMaxLimitDescriptionAndAuthor() {
        Form form = new Form();
        form.setName("Formulaire");
        // 374 characters
        form.setDescription("Eat owner's food. Lick yarn hanging out of own butt thug cat poop on floor and watch human clean up cattt catt cattty cat being a cat yet lick face hiss at owner, pee a lot, and meow repeatedly scratch at fence purrrrrr eat muffins and poutine until owner comes back for bite nose of your human so spill litter box, scratch at owner, destroy all furniture, especially couch.");
        // 69 characters
        form.setAuthor("Lorem ipsum dolor sit amet, consectetur adipiscing elit viverra fusce");
        form.setCreatedAt(Calendar.getInstance().getTime());

        assertFalse(form.isValid());
    }

    @Test
    public void generateHashMapFirebase_isCorrect() {
        Date now = Calendar.getInstance().getTime();

        Form form = new Form();
        form.setName("Formulaire");
        form.setDescription("Une petit description");
        form.setAuthor("Bob");
        form.setCreatedAt(now);

        HashMap formHashMap = form.generateHashMapFirebase();

        HashMap<String, Object> expected = new HashMap<>();
        expected.put("name", "Formulaire");
        expected.put("description", "Une petit description");
        expected.put("author", "Bob");
        expected.put("createdAt", now);

        assertEquals(expected, formHashMap);
    }
}
