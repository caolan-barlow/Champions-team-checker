import java.util.List;

public record TypeEntry(String name, List<String> takesDoubleFrom,
                        List<String> takesHalfFrom, List<String> takesNoneFrom) {}
