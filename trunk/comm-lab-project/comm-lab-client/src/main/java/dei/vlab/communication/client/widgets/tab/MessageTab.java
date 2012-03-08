package dei.vlab.communication.client.widgets.tab;

import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.RichTextEditor;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class MessageTab extends AbstractTab {
	final DynamicForm form = new DynamicForm();
	public static String MESSAGE_TAB_ID = "MESSAGE_TAB_ID";
	public static String MESSAGE_TITLE = "Send Message &nbsp;&nbsp;";
	public static String MESSAGE_ICON = "tools/message.png";

	public MessageTab() {
		super(MESSAGE_TAB_ID);
		setTabTitle(MESSAGE_TITLE);
		setIcon(MESSAGE_ICON, 16);
		setTabHeight100();
		setTabWidth100();

		HLayout inner = new HLayout(20);
		final RichTextEditor richTextEditor = new RichTextEditor();

		createForm(inner,richTextEditor);
		addTabMember(inner);
		addTabMember(richTextEditor);

	}

	private void createForm(HLayout inner,RichTextEditor richTextEditor) {
		form.setWidth(500);

		TextItem toItem = new TextItem();
		toItem.setTitle("To");
		toItem.setRequired(true);
		toItem.setHeight(30);
		toItem.setWidth(400);

		TextItem ccItem = new TextItem();
		ccItem.setTitle("CC");
		ccItem.setRequired(false);
		ccItem.setHeight(30);
		ccItem.setWidth(400);

		TextItem subjectItem = new TextItem();
		subjectItem.setTitle("Subject");
		subjectItem.setRequired(false);
		subjectItem.setWidth(400);

		IButton submitButton = new IButton("Send Message");
		submitButton.setLeft(300);
		submitButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			}
		});

		form.setFields(new FormItem[] { toItem, ccItem, subjectItem, });
		inner.addMember(form);
		inner.addMember(submitButton);
		richTextEditor.setHeight100();
		richTextEditor.setOverflow(Overflow.HIDDEN);
		richTextEditor.setCanDragResize(true);
		richTextEditor.setShowEdges(true);
		inner.addMember(richTextEditor);
		IButton button = new IButton("Send Message");
		button.setWidth(150);
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			}
		});

	}

}
