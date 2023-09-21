package com.vti.repository;

import com.vti.entity.Account;
import com.vti.entity.Group;
import com.vti.form.FormGroup;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GroupRepository implements IGroupRepository{
    private HibernateUtils hibernateUtils;

    public GroupRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @Override
    public void addNewGroup(Group grp) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.save(grp);
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public List<Group> getListGroups() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Group> query = session.createQuery("FROM Group") ;
            return query.list();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void addNewGroupWithAccount(FormGroup formGroup) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = hibernateUtils.openSession();
            transaction = session.getTransaction();
            transaction.begin();

            Account ac = session.get(Account.class, formGroup.getCreatorId());

            Group grp = new Group(
                    formGroup.getGroupName(),
                    formGroup.getTotalMember(),
                    ac,
                    formGroup.getCreatedDate()
            );

            session.save(grp);

            transaction.commit();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void deleteGroups(List<Integer> ids) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = hibernateUtils.openSession();
            transaction = session.getTransaction();
            transaction.begin();

            String deleteQuery = "DELETE FROM Group grp WHERE grp.id IN(:idsParameter)";
            Query query = session.createQuery(deleteQuery);
            query.setParameter("idsParameter", ids);
            query.executeUpdate();

            transaction.commit();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void updateGroup(FormGroup formGroup) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = hibernateUtils.openSession();
            transaction = session.getTransaction();
            transaction.begin();

            Group grp = session.get(Group.class, formGroup.getId());

            if (formGroup.getGroupName() != null && formGroup.getGroupName() != "") {
                grp.setGroupName(formGroup.getGroupName());
            }

            if (formGroup.getTotalMember() != 0) {
                grp.setTotalMember(formGroup.getTotalMember());
            }

            if (formGroup.getCreatorId() != 0) {
                Account ac = session.get(Account.class, formGroup.getCreatorId());
                grp.setCreator(ac);
            }

            if (formGroup.getCreatedDate() != null) {
                grp.setCreatedDate(formGroup.getCreatedDate());
            }

            transaction.commit();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Group> getListGroupsWithSearch(String search) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Group> query = session.createQuery("SELECT grp FROM Group grp WHERE grp.groupName LIKE :searchParameter") ;
            query.setParameter("searchParameter", '%'+search+'%');
            return query.list();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
