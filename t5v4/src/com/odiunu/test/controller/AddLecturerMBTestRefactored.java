package com.odiunu.test.controller;

import com.odiunu.back.services.LecturerService;
import com.odiunu.controller.AddLecturerMB;
import com.odiunu.controller.MBWithMessage;
import org.easymock.Capture;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;

public class AddLecturerMBTestRefactored {
    public static final String NAME = "mockName";
    public static final int ONE = 1;
    private AddLecturerMB addLecturerMB;

    @Before
    public void setUp() throws Exception {
        addLecturerMB = new AddLecturerMB();
    }

    @Test
    public void testAddLecturerCallsLecturerServiceAddLecturer() throws Exception {
        LecturerService lecturerService = EasyMock.createNiceMock(LecturerService.class);
        loadMock(lecturerService, EasyMock.anyObject(), ONE);
        addLecturerMB.setLecturerService(lecturerService);

        addLecturerMB.addLecturer(NAME);

        verify(lecturerService);
    }

    private void loadMock(LecturerService lecturerService, String variable, int x) {
        lecturerService.addLecturer(variable);
        expectLastCall().times(x);
        replay(lecturerService);
    }

    @Test
    public void testAddLecturerAddsCorrectName() {
        Capture<String> capturedName = new Capture<>();
        LecturerService lecturerService = EasyMock.createNiceMock(LecturerService.class);
        loadMock(lecturerService, EasyMock.capture(capturedName), ONE);
        addLecturerMB.setLecturerService(lecturerService);

        addLecturerMB.addLecturer(NAME);

        assert (capturedName.getValue().equals(NAME));
        verify(lecturerService);
    }

    @Test
    public void testIsInstanceOfMBWithMessage() {
        assert (new AddLecturerMB() instanceof MBWithMessage);
    }
}