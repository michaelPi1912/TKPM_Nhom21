package UI.MainForm;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Entity.Bill;
import Entity.Car;
import Entity.Employee;
import Model.BillModel;
import Model.CarModel;
import Model.EmployeeModel;
import Model.GlobalModel;
import Model.ImageHelper;
import UI.BillForm.ExploitBill;
import UI.BillForm.ManagerBill;
import UI.CarForm.CreateBrandForm;
import UI.CarForm.ManagerCarForm;
import UI.EmployeeForm.*;
import UI.Customer.ManagerCustomerForm;
import UI.DeviceForm.ManagerDevice;
import UI.DeviceForm.ManagerJob;
import UI.DeviceForm.SetAmountDevice;
import UI.MainForm.Login;
import UI.RevenueForm.ChartCost;
import UI.RevenueForm.ChartRevenue;
import UI.SystemForm.ChangePasswordForm;
import UI.SystemForm.ContactForm;
import UI.SystemForm.InforUserForm;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.awt.List;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.channels.NonReadableChannelException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Label;
import java.awt.Canvas;

public class Manager extends JFrame{

	private JFrame frame;
	private EmployeeModel employeeModel = new EmployeeModel();
	private JLabel timeSystem;
	private JLabel calendarBD;
	private CarModel carModel = new CarModel();
	private JTable table;
	private ArrayList<Car> listcar = new ArrayList<Car>();
	private ArrayList<Bill> listBills = new ArrayList<Bill>();
	private BillModel billModel = new BillModel();
	
	
	public Manager() throws ClassNotFoundException {
		getContentPane().setLayout(null);
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("???ng d???ng qu???n l?? Gara Xe");
		frame.setBounds(200, 100, 770, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 750, 50);
		frame.getContentPane().add(menuBar);
		
		JMenu mnSystem = new JMenu("H??? th???ng");
		mnSystem.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnSystem);
		
		JMenuItem mntmChangeUser = new JMenuItem("Th??ng tin ng?????i d??ng");
		mntmChangeUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InforUserForm inforUserForm = new InforUserForm();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnSystem.add(mntmChangeUser);
		
		JMenuItem mnitChangePassword = new JMenuItem("?????i m???t kh???u");
		mnitChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePasswordForm changePasswordForm = new ChangePasswordForm();
			}
		});
		mnSystem.add(mnitChangePassword);
		
		JMenuItem mnitExit = new JMenuItem("Tho??t");
		mnitExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		mnSystem.add(mnitExit);
		
		JMenu mnEmpoyee = new JMenu("Nh??n vi??n");
		mnEmpoyee.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnEmpoyee);
		
		JMenuItem mnitChangeEmployee = new JMenuItem("Th??m / X??a / S???a nh??n vi??n");
		mnitChangeEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						ManagerEmployee managerEmployee = new ManagerEmployee();
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		mnEmpoyee.add(mnitChangeEmployee);
		
		JMenuItem mnitAddAcc = new JMenuItem("Th??m t??i kho???n");
		mnitAddAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CreateAccForm createAccForm = new CreateAccForm();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnEmpoyee.add(mnitAddAcc);
		
		JMenuItem nmitUpdateEmpoyee = new JMenuItem("L????ng nh??n vi??n");
		nmitUpdateEmpoyee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					totalSalaryForm ttSalaryForm = new totalSalaryForm();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnEmpoyee.add(nmitUpdateEmpoyee);
		
		JMenu mnCustomer = new JMenu("Kh??ch H??ng");
		mnCustomer.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnCustomer);
		
		JMenuItem mnitChangeCustomer = new JMenuItem("Th??m / X??a / S???a Kh??ch h??ng");
		mnitChangeCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ManagerCustomerForm managerCustomerForm = new ManagerCustomerForm();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnCustomer.add(mnitChangeCustomer);
		
		JMenuItem mnitHistoryTransaction = new JMenuItem("L???ch s??? giao d???ch");
		mnCustomer.add(mnitHistoryTransaction);
		
		JMenu mnGara = new JMenu("Gara Xe");
		mnGara.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnGara);
		
		JMenuItem mnitChangeVehicle = new JMenuItem("Th??m / X??a / S???a Ph????ng ti???n");
		mnitChangeVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ManagerCarForm managerCarForm = new ManagerCarForm();
				} catch (ClassNotFoundException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnGara.add(mnitChangeVehicle);
		
		JMenuItem mnitAddBrand = new JMenuItem("Th??m h??ng xe m???i");
		mnitAddBrand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CreateBrandForm createBrandForm = new CreateBrandForm();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnGara.add(mnitAddBrand);
		
		JMenuItem mnitChangeJob = new JMenuItem("Ph??n c??ng nhi???m v???");
		mnGara.add(mnitChangeJob);
		
		JMenu mnCost = new JMenu("Doanh Thu");
		mnCost.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnCost);
		
		JMenuItem mnitChangeBill = new JMenuItem("H??a ????n");
		mnitChangeBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ManagerBill managerBill = new ManagerBill();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		mnCost.add(mnitChangeBill);
		
		JMenuItem mnitRevenue = new JMenuItem("Doanh thu");
		mnitRevenue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ChartRevenue chartRevenue = new ChartRevenue();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JMenuItem mnitExploitBill = new JMenuItem("Thanh to??n h??a ????n");
		mnitExploitBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listBills = billModel.getAllBills();
					ArrayList<String> listIDBills = new ArrayList<String>();
					for (Bill bill : listBills) {
							listIDBills.add(bill.getID());
					}
					if(listIDBills.size() == 0) {
						JOptionPane.showMessageDialog(null, "Kh??ng c?? h??a ????n ????? thanh to??n",
					              "Thanh to??n", JOptionPane.ERROR_MESSAGE);
					}
					else {
						ExploitBill exploitBill = new ExploitBill();
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnCost.add(mnitExploitBill);
		mnCost.add(mnitRevenue);
		
		JMenuItem mnitCost = new JMenuItem("Chi ph??");
		mnitCost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ChartCost chartCost = new ChartCost();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnCost.add(mnitCost);
		
		JMenu mnMaterial = new JMenu("Kho");
		mnMaterial.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnMaterial);
		
		JMenuItem mnitChangeMaterial = new JMenuItem("Qu???n l?? Kho");
		mnitChangeMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ManagerDevice managerDevice = new ManagerDevice();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnMaterial.add(mnitChangeMaterial);
		
		JMenuItem mnitsetAmoutDevice = new JMenuItem("Nh???p / Xu???t thi???t b???");
		mnitsetAmoutDevice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SetAmountDevice setAmountDevice = new SetAmountDevice();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnMaterial.add(mnitsetAmoutDevice);
		
		JMenuItem mnitJob = new JMenuItem("Qu???n l?? c??ng vi???c");
		mnitJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ManagerJob managerJob = new ManagerJob();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnMaterial.add(mnitJob);
		
		JMenuItem mntmcontact = new JMenuItem("Li??n h??? v???i ch??ng t??i");
		mntmcontact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactForm contactForm = new ContactForm();
			}
		});
		mntmcontact.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mntmcontact);
		

		Label labelInfoUser = new Label("Ch??o " + employeeModel.getNameEmployeebyID());
		labelInfoUser.setBounds(319, 56, 231, 30);
		labelInfoUser.setForeground(Color.BLACK);
		labelInfoUser.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		frame.getContentPane().add(labelInfoUser);
		
		Icon logo = new ImageIcon( getClass().getResource( "image//user.jpg" ) );
        frame.getContentPane().setLayout(null);
		
		//List label
        JLabel lblogo = new JLabel(logo);
        lblogo.setBounds(381, 92, 200, 213);
	    frame.getContentPane().add(lblogo);
	    
		timeSystem = new JLabel();
		timeSystem.setBounds(119, 121, 100, 20);
		timeSystem.setText("Clock");
		timeSystem.setForeground(Color.RED);
		timeSystem.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().add(timeSystem);
		calendarBD = new JLabel();
		calendarBD.setBounds(40, 172, 281, 20);
		calendarBD.setForeground(Color.RED);
		calendarBD.setFont(new Font("Times New Roman", Font.BOLD, 18));
		calendarBD.setText("Calendar");
		frame.getContentPane().add(calendarBD);
		
		String[] columnNames = { "Bi???n s??? Xe", "H??ng", "M?? t???", "M??u", "Tr???ng th??i","Ng??y v??o","Ng??y ra"};
		DefaultTableModel dtm = new DefaultTableModel(columnNames,0);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 310, 684, 178);
		frame.getContentPane().add(scrollPane);
		table = new JTable(dtm);
		listcar = carModel.getAllCar(); 
		for (Car car : listcar) {
			Object[] row = {car.getID(), car.getBrand(), car.getDecription(), car.getColor(),car.getStatus(),car.getDateIn(),car.getDateOut()};
			dtm.addRow(row);
		}
		scrollPane.setViewportView(table);
		
		JButton btnlogout = new JButton("????ng Xu???t");
		btnlogout.setBounds(615, 269, 109, 30);
		btnlogout.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Login login = new Login();
					frame.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnlogout);
		
		JLabel lblNewLabel = new JLabel("Danh S??ch xe trong x?????ng");
		lblNewLabel.setBounds(50, 265, 321, 34);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblNewLabel);
		this.clock();
		
		byte[] pic = employeeModel.getPictureByID(GlobalModel.globalIDUser);
		if(pic != null) {
			Image img;
			try {
				img = ImageHelper.createImageFromByteArray(pic, "jpg");
				img = ImageHelper.resize(img, 140, 160);
				lblogo.setIcon(new ImageIcon(img));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else {
			ImageIcon icon = new ImageIcon(getClass().getResource("image//user.jpg"));
			Image img = ImageHelper.resize(icon.getImage(), 140, 160);
			ImageIcon resizedIcon = new ImageIcon(img);
			lblogo.setIcon(resizedIcon);
		}
		
		if(GlobalModel.globalTypeUser != 0) {
			mnMaterial.hide();
			mnEmpoyee.hide();
			mnitRevenue.hide();
			mnitCost.hide();
		}
		frame.setVisible(true);
		
	}
	public void clock() {
	    Thread clock = new Thread() {
	        public void run() {
	            try {
	                while (true) {
	                    Calendar cal = new GregorianCalendar();
	                    int second = cal.get(Calendar.SECOND);
	                    int minute = cal.get(Calendar.MINUTE);
	                    int hour = cal.get(Calendar.HOUR_OF_DAY);
	                    String thu;
	                    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	                    if (dayOfWeek == 1) {
	                        thu = "Ch??? nh???t";
	                    } else {
	                        thu = "Th??? " + Integer.toString(dayOfWeek);
	                    }
	                    int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
	                    int month = cal.get(Calendar.MONTH);
	                    int year = cal.get(Calendar.YEAR);
	                    timeSystem.setText(hour + ": " + minute + ": " + second);
	                    calendarBD.setText(thu + " Ng??y " + dayOfMonth + " Th??ng " + (month + 1) + " N??m " + year);
	                    sleep(1000);
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    };
	    clock.start();
	}
}
