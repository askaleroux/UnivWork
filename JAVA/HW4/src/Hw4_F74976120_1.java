import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class Hw4_F74976120_1 extends JFrame implements ActionListener
{	
	// �`��
	private static final String[] RecHeader = {"�W��", "�q��", "��}"};
	
	// �����ܼ�
	private DefaultTableModel RecModel;
	private JTable RecTable;
	private boolean editflag = false, colflag = false, rowflag = false, goNext = true;
	
	public static void main(String[] args)
	{
		Hw4_F74976120_1 gui = new Hw4_F74976120_1();
		gui.setVisible(true);
	}
	
	public Hw4_F74976120_1()
	{
		// �����]�w
		super("JAVA HW4 (Address Book) F74976120");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// ���s�ϰ�
		JPanel BtnPane = new JPanel();
		BtnPane.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
		add(BtnPane, BorderLayout.NORTH);
		
		// ���s�ŧi
		JButton NewBtn = new JButton("�s�W");
		JButton DelBtn = new JButton("�R��");
		JButton OutBtn = new JButton("�ץX");
		JButton InBtn = new JButton("�פJ");
		
		// ���sĲ�o�]�w
		NewBtn.setActionCommand("NewRec");
		DelBtn.setActionCommand("DelRec");
		OutBtn.setActionCommand("Output");
		InBtn.setActionCommand("Input");
		NewBtn.addActionListener(this);
		DelBtn.addActionListener(this);
		OutBtn.addActionListener(this);
		InBtn.addActionListener(this);
		
		// ���s�t�m
		BtnPane.add(NewBtn);
		BtnPane.add(DelBtn);
		BtnPane.add(OutBtn);
		BtnPane.add(InBtn);
		
		// ���ŧi�γ]�w
		RecModel = new DefaultTableModel(null, RecHeader);
		RecTable = new JTable(RecModel);
		RecTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		RecTable.getDefaultEditor(String.class).addCellEditorListener(new EditLis());
		RecTable.getSelectionModel().addListSelectionListener(new ListLis());
		RecTable.getColumnModel().addColumnModelListener(new ColLis());
		
		// ���]�w
		TableColumn NameCol = RecTable.getColumnModel().getColumn(0);
		TableColumn TelCol = RecTable.getColumnModel().getColumn(1);
		TableColumn AdrsCol = RecTable.getColumnModel().getColumn(2);
		NameCol.setPreferredWidth(100);
		TelCol.setPreferredWidth(150);
		AdrsCol.setPreferredWidth(432);
		NameCol.setResizable(false);
		TelCol.setResizable(false);
		AdrsCol.setResizable(false);
		
		// ���ʵ����ŧi�γ]�w
		JScrollPane ScrPane = new JScrollPane(RecTable);
		ScrPane.setPreferredSize(new Dimension(700, 450));
		ScrPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		// ��ưϰ�
		JPanel RecPane = new JPanel();
		RecPane.add(ScrPane, BorderLayout.CENTER);
		add(RecPane, BorderLayout.CENTER);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String actionCommand = e.getActionCommand();

		// �s�W
		if(actionCommand.equals("NewRec"))
		{
			// ����s��
			goNext = false;
			if(RecTable.getCellEditor() != null) RecTable.getCellEditor().stopCellEditing();
			if(RecTable.getCellEditor() != null) return;
			
			// �s�W��
			RecModel.addRow(new Object[]{"", "", ""});
			int row = RecModel.getRowCount() - 1;

			// ����öi�J�s��
			RecTable.changeSelection(row, 0, false, false);
			RecTable.editCellAt(row, 0);
			RecTable.getEditorComponent().requestFocusInWindow();
		}
		
		// �R��
		else if(actionCommand.equals("DelRec"))
		{
			// ����s��
			if(RecTable.getCellEditor() != null) RecTable.getCellEditor().cancelCellEditing();
			
			// �R�������
			int row[] = RecTable.getSelectedRows();
			for(int i = 0; i < row.length; i++) RecModel.removeRow(row[0]);
			
			// ����U�@��
			if(row.length > 0)
			{
				if(row[0] > RecTable.getRowCount() - 1) row[0]--;
				RecTable.changeSelection(row[0], 0, false, false);
			}
		}
		
		// ��X�ɮ�
		else if(actionCommand.equals("Output"))
		{
			// ����s��
			goNext = false;
			if(RecTable.getCellEditor() != null) RecTable.getCellEditor().stopCellEditing();
			if(RecTable.getCellEditor() != null) return;
			
			// �ɮ׿�ܾ��ŧi�γ]�w
			JFileChooser Chooser = new JFileChooser();
			Chooser.setDialogTitle("�ץX���");
			Chooser.setCurrentDirectory(new File("."));
			
			// ��ܨè��o�^�ǭ�
			int RtnVal = Chooser.showSaveDialog(this);
			
			// �^�ǽT�{
		    if(RtnVal == JFileChooser.APPROVE_OPTION)
		    {
		    	// �ˬd�ɮצs�b�P�_
				while(Chooser.getSelectedFile().exists())
				{
					// �߰��л\�P�_
					Object[] options = {"�л\", "���s�R�W", "����"};
    				int n = JOptionPane.showOptionDialog(RecTable.getParent(), "�ɮפw�s�b!\n�z�Q�n���N���ɮ׶�?", 
    						"�ɮפw�s�b", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
    				
    				// ���}�j��
    				if(n == JOptionPane.YES_OPTION) break;
    				
    				// �A���߰ݸ��|
    				else if(n == JOptionPane.NO_OPTION)
                    {
    					RtnVal = Chooser.showSaveDialog(this);
    					if(RtnVal != JFileChooser.APPROVE_OPTION) return;
                    }
    				
    				// ���}�禡
                    else
                    {
                    	return;
                    }
				}
				
				// �ץX���
		    	OutputData(Chooser.getSelectedFile());
		    }
		}
		
		// �פJ���
		else if(actionCommand.equals("Input"))
		{
			// �ɮ׿�ܾ��ŧi�γ]�w
			JFileChooser Chooser = new JFileChooser();
			Chooser.setDialogTitle("�פJ���");
			Chooser.setCurrentDirectory(new File("."));
			
			// ��ܨè��o�^�ǭ�
			int RtnVal = Chooser.showOpenDialog(this);
			
			// �^�ǽT�{
		    if(RtnVal == JFileChooser.APPROVE_OPTION)
		    {
		    	// ����s��
		    	if(RecTable.getCellEditor() != null) RecTable.getCellEditor().cancelCellEditing();
		    	
		    	// �פJ���
		    	InputData(Chooser.getSelectedFile());
		    }
		    else
		    {
		    	// �|�b�s��h���^�J�I
		    	if(RecTable.getCellEditor() != null) RecTable.getEditorComponent().requestFocusInWindow();
		    }
		}
	}
	
	private class ListLis implements ListSelectionListener
	{
		// �������ܮ�Ĳ�o
		public void valueChanged(ListSelectionEvent e) {
			
			// ���b�s�説�A
			if(RecTable.getCellEditor() != null && !rowflag)
			{
				// ���o������
				int source = RecTable.getSelectedRow();
				if(source == e.getFirstIndex()) source = e.getLastIndex();
				else source = e.getFirstIndex();
				
				// �����Ĳ�o
				rowflag = true;
				
				// �٭����椧����
				RecTable.changeSelection(source, RecTable.getSelectedColumn(), false, false);
			}
			
			// ��_���`Ĳ�o
			if(rowflag) rowflag = false;
		}
	}
	
	private class ColLis implements TableColumnModelListener
	{

		public void columnAdded(TableColumnModelEvent e) {}
		public void columnMarginChanged(ChangeEvent e) {}
		public void columnMoved(TableColumnModelEvent e) {}
		public void columnRemoved(TableColumnModelEvent e) {}

		// �������ܮ�Ĳ�o
		public void columnSelectionChanged(ListSelectionEvent e)
		{
			// ���b�s�説�A
			if(RecTable.getCellEditor() != null && !colflag)
			{
				// ���o�����
				int source = RecTable.getSelectedColumn();
				if(source == e.getFirstIndex()) source = e.getLastIndex();
				else source = e.getFirstIndex();
				
				// �����Ĳ�o
				colflag = true;
				
				// �٭�����줧����
				RecTable.changeSelection(RecTable.getSelectedRow(), source, false, false);
			}
			
			// ��_���`Ĳ�o
			if(colflag) colflag = false;
		}
	}
	
	private class EditLis implements CellEditorListener
	{
		// �������s���Ĳ�o
	    public void editingStopped(ChangeEvent e)
	    {
	    	// ���o�������m�H�Τ��e�ò����V�c�r��
		    int row = RecTable.getSelectedRow(), col = RecTable.getSelectedColumn();
	    	String value = (RecTable.getValueAt(row, col) + "").replace("\n", " ");
	    	RecTable.setValueAt(value, row, col);
	    	
	    	// �W�����
	    	if(col == 0)
	    	{
	    		// �ŭ�
		    	if(value.equals(""))
		    	{
		    		// �����Ĳ�o
		    		if(!editflag)
			    	{
		    			editflag = true;
			    		return;
			    	}
		    		
		    		// �߰ݬO�_�����
		    		Object[] options = {"�˱󥻵�", "��^�s��"};
					int n = JOptionPane.showOptionDialog(RecTable.getParent(), "�W�٤��i����!\n�z�Q�n��󥻵���ƶ�?", 
							"���X�檺�W��", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
					
					// �R���Ӧ�
    				if(n == JOptionPane.YES_OPTION)
    				{
    					RecModel.removeRow(row);
    					return;
                    }
    				
    				// ��_�s�説�A�è��^�J�I
                    else
                    {
                    	RecTable.changeSelection(row, 0, false, false);
            			RecTable.editCellAt(row, 0);
            			RecTable.getEditorComponent().requestFocusInWindow();
                    }
		    	}
		    	else
		    	{
		    		for(int i = 0; i < RecTable.getRowCount(); i++)
		    		{
		    			// �o�{���ƦW��
		    			if(value.equals(RecTable.getValueAt(i, 0) + "") && i != row)
		    			{
		    				
		    				// �߰ݬO�_���Ψ��N
		    				Object[] options = {"���N�ӵ�", "�˱󥻵�", "��^�s��"};
		    				int n = JOptionPane.showOptionDialog(RecTable.getParent(), "�W�١u" + value + "�v�w�s�b!\n�z�Q�n���N�ӵ���ƶ�?", 
		    						"���ƪ��W��", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[2]);
		    				
		    				// �����ؼЦ�
		    				if(n == JOptionPane.YES_OPTION)
		    				{
		    					RecModel.removeRow(i);
		    					if(row > i) row--;
		                    }
		    				
		    				// ��������
		    				else if(n == JOptionPane.NO_OPTION)
		                    {
		    					RecModel.removeRow(row);
		    					return;
		                    }
		    				
		    				// ��_�s�説�A�è��^�J�I
		                    else
		                    {
		                    	RecTable.changeSelection(row, 0, false, false);
		            			RecTable.editCellAt(row, 0);
		            			RecTable.getEditorComponent().requestFocusInWindow();
		                    }
		    				break;
		    			}
		    		}
		    	}
	    	}
	    	
	    	// �T�굲���s�説�A��
	    	if(RecTable.getCellEditor() == null)
	    	{
	    		if (goNext)
	    		{
		    		// ���@�����G
		    		if(col < 2)
		    		{
		    			// ��������ܰ�Ĳ�o
		    			colflag = true;
		    			rowflag = true;
		    			
		    			// �ϤU�@���i�J�s�説�A�è��o�J�I
	                	RecTable.changeSelection(row, col + 1, false, false);
	        			RecTable.editCellAt(row, col + 1);
	        			RecTable.getEditorComponent().requestFocusInWindow();
		    		}
		    		
		    		// ���T�B�D�̥���
		    		else if(row < RecTable.getRowCount() - 1)
		    		{
		    			// ����U��
	                	RecTable.changeSelection(row + 1, 0, false, false);
		    		}
	    		}
	    		else
	    		{
	    			goNext = true;
	    		}
	    	}
	        
	    	// ��_���`Ĳ�o
	    	if(editflag) editflag = false;
	    }

	    public void editingCanceled(ChangeEvent e) { }
	}
	
	// �ץX���
	private void OutputData(File path)
	{
		try
		{
			FileWriter Writer = new FileWriter(path);
			
			// �q�����o���e�üg�J�ɮ�
			for(int i = 0; i < RecModel.getRowCount(); i++)
			{
				Writer.write(RecTable.getValueAt(i, 0) + "\t");
				Writer.write(RecTable.getValueAt(i, 1) + "\t");
				Writer.write(RecTable.getValueAt(i, 2) + "\r\n");
			}
			Writer.close();
		}
		catch(IOException e) { }
	}
	
	// �פJ���
	private void InputData(File path)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;

			// �M�Ū��
			RecModel.setRowCount(0);
			
			// �̧�Ū����å[�J���
			while((line = br.readLine()) != null)
			{
				String[] RecCell = line.split("\t");
				RecModel.addRow(RecCell);
			}
		}
		catch(IOException e) { }
	}
}
