package me.sewer.guilds.guild;

import me.sewer.guilds.Unique;
import me.sewer.guilds.validity.Validity;

import java.util.UUID;

public class Guild implements Unique {

    private final UUID uniqueId;
    private final GuildRender render;
    private final GuildMemebers memebers;
    private final GuildTerrain terrain;
    private final GuildRelations relations;
    private final GuildCrystal crystal;
    private final Validity validity;

    public Guild(UUID uniqueId, GuildRender render, GuildMemebers memebers, GuildTerrain terrain, GuildRelations relations, GuildCrystal crystal, Validity validity) {
        this.uniqueId = uniqueId;
        this.render = render;
        this.memebers = memebers;
        this.terrain = terrain;
        this.relations = relations;
        this.crystal = crystal;
        this.validity = validity;
    }

    @Override
    public UUID getUniqueId() {
        return this.uniqueId;
    }

    public GuildRender getRender() {
        return this.render;
    }

    public GuildMemebers getMemebers() {
        return this.memebers;
    }

    public GuildTerrain getTerrain() {
        return this.terrain;
    }

    public GuildRelations getRelations() {
        return this.relations;
    }

    public GuildCrystal getCrystal() {
        return crystal;
    }

    public Validity getValidity() {
        return validity;
    }
}
