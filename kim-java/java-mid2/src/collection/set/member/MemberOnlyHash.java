package collection.set.member;

import java.util.Objects;

public class MemberOnlyHash {

    private String id;

    public MemberOnlyHash(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id;
    }
}