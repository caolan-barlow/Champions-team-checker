import java.util.List;

public record TeamMember(
    String pokemonName,
    String item,
    String ability,
    String nature,
    List<String> moves,
    int hpPoints,
    int atkPoints,
    int defPoints,
    int spAtkPoints,
    int spDefPoints,
    int speedPoints){}