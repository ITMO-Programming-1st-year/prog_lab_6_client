package ru.itmo.connection;

import java.io.*;

public class Serializer {

    public static byte[] toByteArray(Object obj) throws IOException {

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(obj);
            out.flush();
            return bos.toByteArray();
        } catch (IOException e) {
            throw e;
        }
    }

    public static Object toObject(byte[] bytes) throws ClassNotFoundException {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes)) {
            ObjectInputStream in = new ObjectInputStream(bis);
            return in.readObject();
        } catch (IOException e) {
            throw new ClassNotFoundException("Error: ObjectOutputStream. Object is damaged. Possible reason: buffer size isn't enough.");
        }
    }
}

