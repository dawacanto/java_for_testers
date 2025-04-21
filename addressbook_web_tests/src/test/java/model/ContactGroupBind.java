package model;

    public class ContactGroupBind {
        public  int contactId;
        public int groupId;

        public ContactGroupBind(int contactId, int groupId) {
            this.contactId = contactId;
            this.groupId = groupId;
        }

        public int getContactId() {
            return contactId;
        }

        public int getGroupId() {
            return groupId;
        }
}
