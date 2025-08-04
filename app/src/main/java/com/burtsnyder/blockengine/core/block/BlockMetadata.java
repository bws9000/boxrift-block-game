package com.burtsnyder.blockengine.core.block;

public final class BlockMetadata {
    public static final long NO_PIECE = 0;
    public static final long NO_GROUP = 0;
    private final long pieceId;
    private final long groupId;
    private final boolean locked;
    private final boolean justSpawned;

    public BlockMetadata() {
        this(NO_PIECE, NO_GROUP, false, true);
    }

    public BlockMetadata(long pieceId, long groupId, boolean locked, boolean justSpawned) {
        this.pieceId = pieceId;
        this.groupId = groupId;
        this.locked = locked;
        this.justSpawned = justSpawned;
    }


    public long getPieceId() { return pieceId; }
    public long getGroupId() { return groupId; }
    public boolean isLocked() { return locked; }
    public boolean isJustSpawned() { return justSpawned; }


    public BlockMetadata copyWith(
            Long pieceId,
            Long groupId,
            Boolean locked,
            Boolean justSpawned
    ) {
        return new BlockMetadata(
                pieceId != null ? pieceId : this.pieceId,
                groupId != null ? groupId : this.groupId,
                locked != null ? locked : this.locked,
                justSpawned != null ? justSpawned : this.justSpawned
        );
    }

    @Override
    public String toString() {
        return String.format(
                "Metadata(pieceId=%d, groupId=%d, locked=%s, justSpawned=%s)",
                pieceId,
                groupId,
                locked,
                justSpawned
        );
    }
}
