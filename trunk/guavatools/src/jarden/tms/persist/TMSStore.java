package jarden.tms.persist;

import java.util.Collection;

public interface TMSStore {
    public Collection<Speaker> getAllSpeakers() throws TMSStoreException;
    public Collection<Speaker> getSpeakersForTalkType(TalkType talkType) throws TMSStoreException;
    public Speaker getSpeaker(long speakerId) throws TMSStoreException;
    public Collection<Speaker> findSpeakerByName(String name) throws TMSStoreException;
}
