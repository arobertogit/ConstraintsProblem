package com.odiunu.test.controller;

import com.odiunu.back.services.LecturerService;
import com.odiunu.controller.AddLecturerMB;
import com.odiunu.controller.MBWithMessage;
import org.easymock.Capture;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;

public class AddLecturerMBTest {
    private AddLecturerMB addLecturerMB;

    @Before
    public void setUp() throws Exception {
        addLecturerMB = new AddLecturerMB();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddLecturerCallsLecturerServiceAddLecturer() throws Exception {
        LecturerService lecturerService = EasyMock.createNiceMock(LecturerService.class);
        lecturerService.addLecturer(EasyMock.anyObject());
        expectLastCall().times(1);
        replay(lecturerService);
        addLecturerMB.setLecturerService(lecturerService);
        addLecturerMB.addLecturer("a");
        verify(lecturerService);
    }

    @Test
    public void testAddLecturerAddsCorrectName(){
        Capture<String> capturedName= new Capture<>();
        LecturerService lecturerService = EasyMock.createNiceMock(LecturerService.class);
        lecturerService.addLecturer(EasyMock.capture(capturedName));
        expectLastCall().times(1);
        replay(lecturerService);

        addLecturerMB.setLecturerService(lecturerService);
        String name = "a";
        addLecturerMB.addLecturer(name);

        assert(capturedName.getValue().equals(name));
        verify(lecturerService);
    }

    @Test
    public void testIsInstanceOfMBWithMessage(){
        assert(new AddLecturerMB() instanceof MBWithMessage);
    }
}