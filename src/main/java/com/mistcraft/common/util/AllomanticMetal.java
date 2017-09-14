package com.mistcraft.common.util;

public enum AllomanticMetal {
    BRASS(11904578),
    BRONZE(13467442),
    COPPER(12088115),
    ELECTRUM(9602857),
    GOLD(13938487),
    IRON(12367026),
    PEWTER(9017993),
    STEEL(11584734),
    TIN(13882581),
    ZINC(12240072);

    private final int color;

    AllomanticMetal(int color) {
        this.color = color;
    }

    public int color() {
        return this.color;
    }
}
