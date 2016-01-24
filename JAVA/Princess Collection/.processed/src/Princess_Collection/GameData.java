package Princess_Collection;

class GameData {

	public CardData[] Card;
	public AIData[] AI;
	public SkillData[] Skill;
	public SkillModel[] Model;
			
	public static class Atb {
		public static final int BEAT = 0;
		public static final int FIRE = 1;
		public static final int TUNDER = 2;
		public static final int LIGHT = 3;
		public static final int DARK = 4;
		public static final int BUFF = 5;
		public static final int DEBUFF = 6;
	}
	
	public static class Pty {
		public static final int NONE = 0;
		public static final int STR = 1;
		public static final int SPD = 2;
		public static final int ATK = 3;
		public static final int INT = 4;
	}
	
	public static class Gup {
		public static final int TOHEARTH2 = 0;
		public static final int UTAWARERUMONO = 1;
		public static final int TEARSTOTIARA = 2;
		public static final int KUSARI = 3;
		public static final int FULLANI = 4;
	}
	
	GameData(){
		Card = new CardData[65];
				
		Card[0] = new CardData(400, 10, 62, 51, 1, false, Atb.LIGHT, Gup.TOHEARTH2, 4, 6, 0, 1);
		Card[1] = new CardData(700, 90, 66, 18, 3, true, Atb.BEAT, Gup.TOHEARTH2, 5, 2, 2, 3);
		Card[2] = new CardData(600, 78, 23, 55, 2, true, Atb.BEAT, Gup.TOHEARTH2, 3, 5, 4, 5);
		Card[3] = new CardData(400, 18, 70, 80, 1, false, Atb.TUNDER, Gup.TOHEARTH2, 2, 2, 6, 7);
		Card[4] = new CardData(500, 72, 13, 41, 1, true, Atb.BEAT, Gup.TOHEARTH2, 2, 2, 8, 9);
		Card[5] = new CardData(300, 12, 88, 78, 1, false, Atb.TUNDER, Gup.TOHEARTH2, 4, 3, 10, 11);
		Card[6] = new CardData(500, 61, 71, 84, 2, false, Atb.DARK, Gup.TOHEARTH2, 3, 3, 12, 13);
		Card[7] = new CardData(600, 30, 84, 23, 2, true, Atb.LIGHT, Gup.TOHEARTH2, 3, 3, 14, 15);
		Card[8] = new CardData(700, 66, 78, 70, 3, true, Atb.DARK, Gup.TOHEARTH2, 6, 6, 16, 17);
		Card[9] = new CardData(300, 18, 57, 71, 1, false, Atb.LIGHT, Gup.TOHEARTH2, 2, 2, 18, 19);
		Card[10] = new CardData(500, 60, 75, 34, 2, true, Atb.FIRE, Gup.TOHEARTH2, 2, 4, 20, 21);
		Card[11] = new CardData(600, 79, 31, 54, 2, true, Atb.BEAT, Gup.TOHEARTH2, 4, 6, 22, 23);
		Card[12] = new CardData(600, 78, 66, 45, 2, true, Atb.BEAT, Gup.TOHEARTH2, 3, 4, 24, 25);
		Card[13] = new CardData(800, 81, 31, 10, 3, true, Atb.BEAT, Gup.TOHEARTH2, 4, 2, 26, 27);
		Card[14] = new CardData(400, 30, 62, 65, 1, false, Atb.FIRE, Gup.TOHEARTH2, 2, 6, 28, 29);
		Card[15] = new CardData(500, 61, 27, 53, 1, true, Atb.BEAT, Gup.TOHEARTH2, 2, 4, 30, 31);
		Card[16] = new CardData(300, 10, 68, 28, 1, false, Atb.FIRE, Gup.TOHEARTH2, 2, 4, 32, 33);
		Card[17] = new CardData(600, 20, 70, 40, 2, false, Atb.TUNDER, Gup.TOHEARTH2, 4, 6, 34, 35);
		Card[18] = new CardData(400, 12, 62, 42, 1, false, Atb.DARK, Gup.TOHEARTH2, 2, 6, 36, 37);
		
		Card[19] = new CardData(300, 18, 65, 64, 1, false, Atb.LIGHT, Gup.UTAWARERUMONO, 6, 2, 38, 39);
		Card[20] = new CardData(700, 60, 28, 31, 1, true, Atb.BEAT, Gup.UTAWARERUMONO, 2, 2, 40, 41);
		Card[21] = new CardData(500, 76, 76, 63, 2, true, Atb.BEAT, Gup.UTAWARERUMONO, 2, 3, 42, 43);
		Card[22] = new CardData(400, 68, 32, 50, 1, false, Atb.BEAT, Gup.UTAWARERUMONO, 2, 2, 44, 45);
		Card[23] = new CardData(400, 68, 32, 50, 1, false, Atb.BEAT, Gup.UTAWARERUMONO, 2, 2, 46, 47);
		Card[24] = new CardData(500, 78, 13, 92, 2, true, Atb.BEAT, Gup.UTAWARERUMONO, 2, 4, 48, 49);
		Card[25] = new CardData(700, 98, 25, 10, 3, true, Atb.BEAT, Gup.UTAWARERUMONO, 4, 2, 50, 51);
		Card[26] = new CardData(600, 73, 41, 77, 3, true, Atb.BEAT, Gup.UTAWARERUMONO, 2, 2, 52, 53);
		Card[27] = new CardData(500, 17, 84, 19, 2, false, Atb.LIGHT, Gup.UTAWARERUMONO, 2, 4, 54, 55);
		Card[28] = new CardData(300, 12, 76, 50, 1, false, Atb.DARK, Gup.UTAWARERUMONO, 2, 2, 56, 57);
		Card[29] = new CardData(300, 22, 94, 12, 3, false, Atb.DARK, Gup.UTAWARERUMONO, 4, 6, 58, 59);
		Card[30] = new CardData(800, 84, 10, 23, 2, true, Atb.BEAT, Gup.UTAWARERUMONO, 4, 1, 60, 61);
		Card[31] = new CardData(600, 71, 80, 50, 2, true, Atb.BEAT, Gup.UTAWARERUMONO, 4, 2, 62, 63);
		Card[32] = new CardData(100, 10, 78, 33, 1, false, Atb.LIGHT, Gup.UTAWARERUMONO, 4, 8, 64, 65);
		Card[33] = new CardData(500, 72, 56, 66, 2, true, Atb.BEAT, Gup.UTAWARERUMONO, 3, 4, 66, 67);
		
		Card[34] = new CardData(700, 81, 88, 32, 3, true, Atb.BEAT, Gup.TEARSTOTIARA, 2, 3, 68, 69);
		Card[35] = new CardData(300, 10, 71, 51, 1, false, Atb.TUNDER, Gup.TEARSTOTIARA, 2, 3, 70, 71);
		Card[36] = new CardData(700, 77, 69, 50, 2, true, Atb.BEAT, Gup.TEARSTOTIARA, 2, 1, 72, 73);
		Card[37] = new CardData(500, 74, 40, 36, 2, true, Atb.BEAT, Gup.TEARSTOTIARA, 2, 2, 74, 75);
		Card[38] = new CardData(500, 69, 76, 77, 2, true, Atb.BEAT, Gup.TEARSTOTIARA, 4, 6, 76, 77);
		Card[39] = new CardData(500, 43, 88, 24, 2, false, Atb.TUNDER, Gup.TEARSTOTIARA, 3, 2, 78, 79);
		Card[40] = new CardData(500, 35, 73, 45, 1,	false, Atb.DARK, Gup.TEARSTOTIARA, 6, 3, 80, 81);
		Card[41] = new CardData(400, 21, 78, 88, 1, false, Atb.DARK, Gup.TEARSTOTIARA, 4, 3, 82, 83);
		Card[42] = new CardData(300, 13, 73, 67, 1, false, Atb.TUNDER, Gup.TEARSTOTIARA, 6, 4, 84, 85);
		Card[43] = new CardData(400, 21, 77, 27, 1, false, Atb.LIGHT, Gup.TEARSTOTIARA, 2, 2, 86, 87);
		Card[44] = new CardData(400, 23, 60, 31, 1, false, Atb.LIGHT, Gup.TEARSTOTIARA, 2, 2, 88, 89);
		Card[45] = new CardData(500, 50, 50, 50, 1, false, Atb.LIGHT, Gup.TEARSTOTIARA, 4, 4, 90, 91);
		Card[46] = new CardData(600, 73, 40, 31, 2, true, Atb.BEAT, Gup.TEARSTOTIARA, 2, 6, 92, 93);
		
		Card[47] = new CardData(500, 27, 63, 82, 2, false, Atb.FIRE, Gup.KUSARI, 2, 6, 94, 95);
		Card[48] = new CardData(400, 43, 61, 50, 2, false, Atb.TUNDER, Gup.KUSARI, 4, 2, 96, 97);
		Card[49] = new CardData(400, 57, 59, 61, 2, false, Atb.TUNDER, Gup.KUSARI, 2, 4, 98, 99);
		Card[50] = new CardData(400, 27, 59, 49, 1, false, Atb.FIRE, Gup.KUSARI, 2, 6, 100, 101);
		Card[51] = new CardData(400, 40, 49, 91, 1, true, Atb.TUNDER, Gup.KUSARI, 4, 1, 102, 103);
		Card[52] = new CardData(600, 66, 70, 52, 2, true, Atb.FIRE, Gup.KUSARI, 2, 2, 104, 105);
		Card[53] = new CardData(800, 79, 66, 13, 3, false, Atb.BEAT, Gup.KUSARI, 7, 9, 106, 107);
		Card[54] = new CardData(500, 61, 51, 50, 1, true, Atb.BEAT, Gup.KUSARI, 2, 2, 108, 109);
		Card[55] = new CardData(700, 70, 54, 71, 2, true, Atb.BEAT, Gup.KUSARI, 2, 2, 110, 111);
		
		Card[56] = new CardData(300, 61, 43, 22, 1, true, Atb.BEAT, Gup.FULLANI, 2, 4, 112, 113);
		Card[57] = new CardData(500, 22, 71, 27, 2, false, Atb.LIGHT, Gup.FULLANI, 4, 4, 114, 115);
		Card[58] = new CardData(600, 73, 30, 50, 3, true, Atb.BEAT, Gup.FULLANI, 2, 6, 116, 117);
		Card[59] = new CardData(500, 30, 73, 40, 3, true, Atb.LIGHT, Gup.FULLANI, 2, 4, 118, 119);
		Card[60] = new CardData(300, 33, 69, 60, 2, false, Atb.TUNDER, Gup.FULLANI, 2, 4, 120, 121);
		Card[61] = new CardData(400, 61, 63, 30, 1, true, Atb.FIRE, Gup.FULLANI, 2, 2, 121, 122);
		Card[62] = new CardData(300, 20, 82, 53, 2, false, Atb.DARK, Gup.FULLANI, 6, 8, 123, 124);
		Card[63] = new CardData(700, 86, 30, 65, 3, true, Atb.BEAT, Gup.FULLANI, 2, 4, 125, 126);
		Card[64] = new CardData(600, 61, 89, 40, 3, true, Atb.DARK, Gup.FULLANI, 9, 9, 127, 128);
	
		AI = new AIData[24];

		AI[0] = new AIData(14, 7, 16, 3, "044103040000", "444055555555", 12);
		AI[1] = new AIData(28, 33, 19, 30, "4040104040400040", "4444044444444444", 12);
		
		for (int i = 2; i < 24; i++){
			AI[i] = new AIData(14, 7, 16, 3, "044103040000", "444055555555", 12);
		}
		
		Skill = new SkillData[130];

		Skill[0] = new SkillData(0, "�v¡����", Atb.BUFF, 2, 80, Pty.NONE, "�ϧڭxHP�^�_", "", 4, 1);
		Skill[1] = new SkillData(0, "���Ǫ�����", Atb.BUFF, 3, 90, Pty.NONE, "�ϧڭxHP�j�T�^�_", "", 6, 1);
		Skill[2] = new SkillData(1, "�K��", Atb.BEAT, 1.5, 80, Pty.NONE, "�����Ĥ����j�O���ݩʧ���", "", 5, 0);
		Skill[3] = new SkillData(5, "�Q�k���ݲ�", Atb.BUFF, 0, 0, Pty.INT, "�ϧڤ���鴼�O�M�äO�W��", "�ۨ����O�V���ĪG�ɶ��V��", 2, 1);		
		Skill[4] = new SkillData(1, "�����q��YOYO", Atb.BEAT, 1, 30, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`�ô����ۨ��äO", "�ۨ����O�V���ĪG�ɶ��V��", 3, 1);
		Skill[5] = new SkillData(3, "�}�񨮬���", Atb.BEAT, 1.25, 10, Pty.NONE, "�����Ĥ�������ݩʶˮ`", "", 5, 0);
		Skill[6] = new SkillData(1, "�S���Ķ��~", Atb.BEAT, 1, 30, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "�����v�Ϩ�·�", 2, 1);
		Skill[7] = new SkillData(1, "�Z�����p", Atb.TUNDER, 1, 20, Pty.NONE, "�����Ĥ�@�H�p�ݩʶˮ`", "", 2, 0);
		Skill[8] = new SkillData(1, "�y��", Atb.BEAT, 1, 40, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "", 2, 0);
		Skill[9] = new SkillData(0, "����", Atb.BUFF, 0, 0, Pty.NONE, "�ϤU�^�X�ۨ������O�W��", "", 2, 1);
		Skill[10] = new SkillData(3, "���", Atb.TUNDER, 0.8, 500, Pty.NONE, "�����Ĥ����p�ݩʶˮ`", "�C���v�����ݩʥH�~���ޯ�ʦL", 4, 0);
		Skill[11] = new SkillData(5, "�W�W", Atb.BUFF, 0, 0, Pty.NONE, "�ϧڤ���鴼�O�W��", "�ۨ����O�V���ĪG�ɶ��V��", 3, 1);
		Skill[12] = new SkillData(1, "������", Atb.BEAT, 1, 60, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "", 3, 1);
		Skill[13] = new SkillData(1, "����N����", Atb.DARK, 1, 20, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "�����v�Ϩ䤤�r", 3, 1);
		Skill[14] = new SkillData(1, "�S�㡸", Atb.LIGHT, 1, 40, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "", 3, 1);
		Skill[15] = new SkillData(1, "�S���S�S�B�S��", Atb.TUNDER, 1, 40, Pty.NONE, "�����Ĥ�@�H�p�ݩʶˮ`", "", 3, 1);
		Skill[16] = new SkillData(3, "���`", Atb.FIRE, 1.5, 0, Pty.NONE, "�����Ĥ���骢�ݩʶˮ`", "", 6, 1);
		Skill[17] = new SkillData(3, "����", Atb.DARK, 1.25, 0, Pty.NONE, "�����Ĥ�������ݩʶˮ`�èϨ�t�פU��", "�Ĥ贼�O�V�C�ĪG�ɶ��V��", 6, 1);
		Skill[18] = new SkillData(4, "�u�@���q", Atb.BUFF, 0, 0, Pty.NONE, "�ϧڤ�@�H���ݩʭ@�ʤW��", "�ۨ����O�V���ĪG�ɶ��V��", 2, 1);
		Skill[19] = new SkillData(4, "�������q", Atb.BUFF, 0, 0, Pty.NONE, "�ϧڤ�@�H�äO�W��", "�ۨ����O�V���ĪG�ɶ��V��", 2, 1);
		Skill[20] = new SkillData(1, "�������i", Atb.BEAT, 1, 40, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "", 2, 0);
		Skill[21] = new SkillData(1, "�L��", Atb.FIRE, 1.25, 40, Pty.NONE, "�����Ĥ�@�H�j�O���ݩʶˮ`", "", 4, 1);
		Skill[22] = new SkillData(3, "�ȪO����", Atb.BEAT, 1, 10, Pty.NONE, "�����Ĥ�������ݩʶˮ`", "", 4, 0);
		Skill[23] = new SkillData(3, "�ȪO������", Atb.BEAT, 1.5, 10, Pty.NONE, "�����Ĥ����j�O���ݩʶˮ`", "", 6, 0);
		Skill[24] = new SkillData(3, "�Ӧ^�ե�", Atb.BEAT, 1, 0, Pty.NONE, "�����Ĥ�������ݩʶˮ`", "", 3, 0);
		Skill[25] = new SkillData(1, "�B�@", Atb.BEAT, 1, 70, Pty.NONE, "�����Ĥ�@�H�j�O���ݩʶˮ`", "�����v�Ϩ䤤�r", 4, 0);
		Skill[26] = new SkillData(1, "���N����", Atb.BEAT, 1, 80, Pty.NONE, "�����Ĥ�@�H�j�O���ݩʶˮ`", "", 4, 0);
		Skill[27] = new SkillData(0, "�R�q", Atb.BUFF, 0, 0, Pty.NONE, "�ۨ����ݩʤ��@�ʤW��", "�ۨ����O�V���ĪG�ɶ��V��", 2, 1);
		Skill[28] = new SkillData(1, "�j���N����", Atb.FIRE, 1, 20, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "�ô����ۨ����O", 2, 0);
		Skill[29] = new SkillData(3, "�����j���N����", Atb.FIRE, 1.25, 0, Pty.NONE, "�����Ĥ������ݩʶˮ`", "", 6, 0);
		Skill[30] = new SkillData(1, "���魫��", Atb.BEAT, 1, 40, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "", 2, 0);
		Skill[31] = new SkillData(3, "�G���T���v", Atb.BEAT, 1, 10, Pty.NONE, "�����Ĥ�������ݩʶˮ`", "", 4, 0);
		Skill[32] = new SkillData(1, "���y�N", Atb.FIRE, 1, 20, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "", 2, 1);
		Skill[33] = new SkillData(3, "���K���R", Atb.FIRE, 1, 0, Pty.NONE, "�����Ĥ������ݩʶˮ`", "", 4, 1);
		Skill[34] = new SkillData(3, "�p�½���", Atb.TUNDER, 1, 0, Pty.NONE, "�����Ĥ����p�ݩʶˮ`", "", 4, 0);
		Skill[35] = new SkillData(3, "�p�Y��", Atb.TUNDER, 1.25, 0, Pty.NONE, "�����Ĥ�������ݩʶˮ`", "�C���v�Ϩ�·�", 6, 0);
		Skill[36] = new SkillData(1, "�����Ʋ�", Atb.DARK, 1, 20, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "", 2, 1);
		Skill[37] = new SkillData(3, "�i�ê�����", Atb.DARK, 1, 0, Pty.NONE, "�����Ĥ�������ݩʶˮ`�Ϩ���ݩʤ��@�ʤU��", "�ؼд��O�V�C�ĪG�ɶ��V��", 6, 1);
		Skill[38] = new SkillData(4, "�ĳN", Atb.BUFF, 0, 0, Pty.NONE, "�ϧڭxHP�j�T�^�_", "", 6, 1);
		Skill[39] = new SkillData(1, "�r�N", Atb.BEAT, 1, 40, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "�����v�Ϩ䤤�r", 4, 1);
		Skill[40] = new SkillData(1, "�r�ꤧ�r", Atb.BEAT, 1, 40, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "", 2, 0);
		Skill[41] = new SkillData(4, "�H��", Atb.BEAT, 0, 0, Pty.NONE, "�ϧڤ�@�H���`���A�^�_", "���O�ǷL�W��", 2, 1);
		Skill[42] = new SkillData(1, "���Ǥ��K��", Atb.BEAT, 1, 40, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "�C���v�Ϩ䤤�r", 2, 0);
		Skill[43] = new SkillData(5, "�i�x���j���O", Atb.BUFF, 0, 0, Pty.NONE, "�ϧڤ����äO�P���O�W��", "�ۨ����O�V���ĪG�ɶ��V��", 3, 1);
		Skill[44] = new SkillData(1, "����", Atb.BEAT, 1, 40, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "", 2, 0);
		Skill[45] = new SkillData(1, "����(�M)", Atb.BEAT, 1, 0, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`�Ϩ䴼�O�U��", "�L�k��סA�ؼд��O�V�C�ĪG�ɶ��V��", 2, 0);
		Skill[46] = new SkillData(1, "����", Atb.BEAT, 1, 40, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "", 2, 0);
		Skill[47] = new SkillData(1, "����(�})", Atb.BEAT, 1, 0, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`�Ϩ����ݩʭ@�ʤU��", "�L�k��סA�ؼд��O�V�C�ĪG�ɶ��V��", 2, 0);
		Skill[48] = new SkillData(1, "�Z�M�y", Atb.BEAT, 1, 20, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`�Ϩ�t�פU��", "�ؼд��O�V�C�ĪG�ɶ��V��", 2, 0);
		Skill[49] = new SkillData(3, "���ûR", Atb.BEAT, 1, 1000, Pty.NONE, "�����Ĥ�������ݩʶˮ`", "", 4, 0);
		Skill[50] = new SkillData(1, "��C���@��", Atb.BEAT, 1, 80, Pty.NONE, "�����Ĥ�@�H�j�O���ݩʶˮ`", "", 4, 0);
		Skill[51] = new SkillData(0, "�äO�ֿn", Atb.BUFF, 0, 0, Pty.NONE, "�U�^�X�ۨ������O�W��", "", 2, 1);
		Skill[52] = new SkillData(2, "�դb�@�{", Atb.BEAT, 1, 10, Pty.NONE, "�ǵ۳e�q��W�Ĥ赹�����ݩʶˮ`", "", 2, 0);
		Skill[53] = new SkillData(1, "�M�I����", Atb.TUNDER, 1, 20, Pty.NONE, "�����Ĥ�@�H�p�ݩʶˮ`", "�C���v�Ϩ�·�", 2, 0);
		Skill[54] = new SkillData(1, "�٫ߤ���", Atb.LIGHT, 1, 20, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "", 2, 1);
		Skill[55] = new SkillData(5, "�j�����H��", Atb.BUFF, 0, 0, Pty.NONE, "�ϧڤ���鲧�`���A�^�_", "", 4, 1);
		Skill[56] = new SkillData(1, "�٫ߤ���", Atb.DARK, 1, 20, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "", 2, 1);
		Skill[57] = new SkillData(0, "�¦Ф�����", Atb.BUFF, 0, 0, Pty.NONE, "�U�^�X�ۨ����O�W��", "", 2, 1);
		Skill[58] = new SkillData(3, "�b�Ƥ��ª�", Atb.DARK, 0.8, 0, Pty.NONE, "�����Ĥ�������ݩʶˮ`�Ϩ���ݩʤ��@�ʤU��", "�ؼд��O�V�C�ĪG�ɶ��V��", 4, 1);
		Skill[59] = new SkillData(1, "�l�����O", Atb.DARK, 1.25, 30, Pty.NONE, "�����Ĥ�@�H�j�O���ݩʶˮ`�Ϩ���ݩʤ��@�ʤU��", "�ؼд��O�V�C�ĪG�ɶ��V��", 6, 1);
		Skill[60] = new SkillData(2, "���j����", Atb.BEAT, 1, 20, Pty.NONE, "�ǵ۳e�q��W�Ĥ赹�����ݩʶˮ`", "", 4, 0);
		Skill[61] = new SkillData(0, "�믫����", Atb.BUFF, 0, 0, Pty.NONE, "�ۨ������ݩʤ��@�ʤj�T�W��", "�ۨ����O�V���ĪG�ɶ��V��", 1, 1);
		Skill[62] = new SkillData(2, "���j����", Atb.BEAT, 1, 20, Pty.NONE, "�ǵ۳e�q��W�Ĥ赹�����ݩʶˮ`", "", 4, 0);
		Skill[63] = new SkillData(5, "���R", Atb.BUFF, 0, 0, Pty.NONE, "�ϧڤ����äO�W��", "�ۨ����O�V���ĪG�ɶ��V��", 2, 1);
		Skill[64] = new SkillData(1, "�ιڤ��ܽ�", Atb.LIGHT, 1, 30, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`�Ϩ䦳���v�ίv", "�ؼд��O�V�C�ĪG�ɶ��V��", 4, 1);
		Skill[65] = new SkillData(3, "�ιڤ��I�l", Atb.DEBUFF, 0, 0, Pty.NONE, "�ϼĤ���馳���v�ίv", "�ؼд��O�V�C�ĪG�ɶ��V��", 8, 1);
		Skill[66] = new SkillData(2, "��z���@", Atb.BEAT, 1, 15, Pty.NONE, "�ǵ۳e�q��W�Ĥ赹�����ݩʶˮ`", "", 3, 0);
		Skill[67] = new SkillData(1, "�@�r���@", Atb.BEAT, 1, 60, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "�Ϩ䦳���v���r", 4, 1);
		Skill[68] = new SkillData(1, "���}��", Atb.DARK, 1, 30, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "", 2, 0);
		Skill[69] = new SkillData(5, "�]���z�A", Atb.BUFF, 0, 0, Pty.NONE, "�ϧڤ���鴼�O�W��", "�ۨ����O�V���ĪG�ɶ��V��", 3, 1);
		Skill[70] = new SkillData(0, "�]�O�W�j", Atb.BUFF, 0, 0, Pty.NONE, "�T�w�^�X���ڭx�]�O�W�[", "�ۨ����O�V���ĪG�ɶ��V��", 6, 1);
		Skill[71] = new SkillData(3, "�@�ɾ�", Atb.TUNDER, 1, 0, Pty.NONE, "�����Ĥ����p�ݩʶˮ`", "�C���v�����ݩʥH�~���ޯ�ʦL", 4, 1);
		Skill[72] = new SkillData(1, "�����", Atb.BEAT, 1, 40, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "", 2, 0);
		Skill[73] = new SkillData(0, "�˨�", Atb.BUFF, 0, 0, Pty.NONE, "�T���׹��ۨ���誺����", "�ۨ����O�V���ĪG�ɶ��V��", 1, 1);
		Skill[74] = new SkillData(1, "��@��", Atb.BEAT, 1, 40, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "�L�k���", 2, 0);
		Skill[75] = new SkillData(1, "�ѫo����", Atb.BEAT, 1, 20, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "�����v�����ݩʥH�~���ޯ�ʦL�A�L�k���", 2, 0);
		Skill[76] = new SkillData(2, "�Q����", Atb.BEAT, 1, 20, Pty.NONE, "�ǵ۳e�q��W�Ĥ赹�����ݩʶˮ`", "", 4, 0);
		Skill[77] = new SkillData(1, "�g��", Atb.BEAT, 1.5, 90, Pty.NONE, "�����Ĥ�@�H�j�O���ݩʶˮ`", "�ڭxHP�ǷL�^�_", 6, 0);
		Skill[78] = new SkillData(5, "��T�Ƥ��u�@", Atb.BUFF, 0, 0, Pty.NONE, "�ϧڤ������@�ʤW��", "�ۨ����O�V���ĪG�ɶ��V��", 3, 1);
		Skill[79] = new SkillData(1, "��������", Atb.LIGHT, 1, 20, Pty.NONE, "�����Ĥ�@�H�p�ݩʶˮ`", "", 2, 0);
		Skill[80] = new SkillData(1, "���몺�n�x��", Atb.DARK, 1.25, 60, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`�Ϩ䦳���v�ίv", "�ؼд��O�V�C�ĪG�ɶ��V��", 6, 1);
		Skill[81] = new SkillData(5, "�g�������R��", Atb.BUFF, 0, 0, Pty.NONE, "�ϧڤ����äO�P���O����,���@�ʤU��", "�ۨ����O�V���ĪG�ɶ��V��", 3, 1);
		Skill[82] = new SkillData(1, "���뤧��", Atb.DARK, 1, 40, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`�C���v�Ϩ�ίv", "�ؼд��O�V�C�ĪG�ɶ��V��", 4, 1);
		Skill[83] = new SkillData(3, "�]�k���y", Atb.DEBUFF, 0, 0, Pty.NONE, "�ĭx�]�O�U��", "", 3, 0);
		Skill[84] = new SkillData(3, "����g��", Atb.TUNDER, 1.25, 20, Pty.NONE, "�����Ĥ����p�ݩʶˮ`", "�C���v�Ϩ䤤�r", 6, 0);
		Skill[85] = new SkillData(3, "�z�H", Atb.TUNDER, 1, 1000, Pty.NONE, "���Ĥ����p�ݩʶˮ`", "", 4, 0);
		Skill[86] = new SkillData(4, "�v¡����", Atb.BUFF, 0, 0, Pty.NONE, "�ϧڭxHP�ֶq�^�_", "", 2, 1);
		Skill[87] = new SkillData(5, "�I�����}", Atb.BUFF, 0, 0, Pty.NONE, "�ϧڤ����äO����,���O�U��", "�ۨ����O�V���ĪG�ɶ��V��", 2, 1);
		Skill[88] = new SkillData(4, "�v¡����", Atb.BUFF, 0, 0, Pty.NONE, "�ϧڭxHP�ֶq�^�_", "", 2, 1);
		Skill[89] = new SkillData(5, "�O�гN", Atb.BUFF, 0, 0, Pty.NONE, "�ϧڤ����ʦL���A�Ѱ�", "�ۨ����O�V���ĪG�ɶ��V��", 2, 1);
		Skill[90] = new SkillData(1, "�r�����N", Atb.LIGHT, 1, 30, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "�����v���r", 4, 1);
		Skill[91] = new SkillData(1, "�ѫo�����N", Atb.LIGHT, 1, 0, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "�����v���ݩʥH�~���ޯ�ʦL", 4, 1);
		Skill[92] = new SkillData(1, "�M�h�D�믫", Atb.BEAT, 1, 40, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "", 2, 0);
		Skill[93] = new SkillData(3, "Misuterion", Atb.BEAT, 1.25, 20, Pty.NONE, "�����Ĥ�������ݩʶˮ`", "�Ϩ����ݩʭ@�ʤU��", 6, 0);
		Skill[94] = new SkillData(1, "���椧��", Atb.FIRE, 1, 0, Pty.NONE, "�����Ĥ�@�H���ݩʶˮ`", "�ڭxHP�V�֫¤O�V��", 2, 1);
		Skill[95] = new SkillData(5, "�򿣪��ۥs", Atb.BUFF, 0, 0, Pty.NONE, "�ϧڤ����äO�P���O����", "�ĭx�]�O�V�֮ĪG�V��", 6, 1);
		Skill[96] = new SkillData(1, "�򿣤��·�", Atb.LIGHT, 1, 30, Pty.NONE, "�����Ĥ�@�H�p�ݩʶˮ`�����v�Ϩ�·�", "�ĭx�]�O�V�ֳ·����v�V��", 4, 1);
		Skill[97] = new SkillData(5, "��a", Atb.BUFF, 0, 0, Pty.NONE, "�ϧڤ���鴼�O����,���@�ʤU��", "�ۨ����O�V���ĪG�ɶ��V��", 2, 1);
		Skill[98] = new SkillData(0, "���檺�{��", Atb.BUFF, 0, 0, Pty.NONE, "�Ϧۨ������O�����A�ڭx��HP�V�֮ĪG�V��", "�ۨ����O�V���ĪG�ɶ��V��", 2, 1);
		Skill[99] = new SkillData(3, "�_�S�~���u", Atb.TUNDER, 1, 500, Pty.NONE, "�ϼĤ����y���p�ݩʧ���", "", 4, 1);
		Skill[100] = new SkillData(1, "���椧��", Atb.FIRE, 1, 0, Pty.NONE, "�����Ĥ�@�H���ݩʧ���", "�ڭx��HP�V�֫¤O�V��", 2, 1);
		Skill[101] = new SkillData(4, "��", Atb.BUFF, 0, 0, Pty.NONE, "�T�w�^�X���ڭx�]�O�W�[", "�ۨ����O�V���ĪG�ɶ��V��", 6, 1);
		Skill[102] = new SkillData(3, "PUPPY����", Atb.BUFF, 0, 0, Pty.NONE, "�Ϧۨ������ݩʤ��@�ʤj�T����", "�ۨ����O�V���ĪG�ɶ��V��", 4, 1);
		Skill[103] = new SkillData(3, "�˨�", Atb.BUFF, 0, 0, Pty.NONE, "�T���׹��ۨ���誺����", "�ۨ����O�V���ĪG�ɶ��V��", 1, 1);
		Skill[104] = new SkillData(1, "������", Atb.FIRE, 1, 20, Pty.NONE, "�����Ĥ�@�H���ݩʧ���", "", 2, 1);
		Skill[105] = new SkillData(0, "�M�����u�@", Atb.BUFF, 0, 0, Pty.NONE, "�Ϧۨ������ݩʭ@�ʤj�T����", "�ۨ����O�V���ĪG�ɶ��V��", 2, 1);
		Skill[106] = new SkillData(1, "���", Atb.BEAT, 2, 100, Pty.NONE, "�����Ĥ�@�H�j�O���ݩʧ���", "", 7, 0);
		Skill[107] = new SkillData(3, "����", Atb.BEAT, 1.5, 30, Pty.NONE, "�����Ĥ�������ݩʧ���", "", 9, 0);
		Skill[108] = new SkillData(1, "������", Atb.BEAT, 1, 40, Pty.NONE, "�����Ĥ�@�H���ݩʧ���", "�L�k���", 2, 0);
		Skill[109] = new SkillData(5, "�������", Atb.BUFF, 0, 0, Pty.NONE, "�ϧڤ���骺�t�״���", "�ۨ����O�V���ĪG�ɶ��V��", 2, 1);
		Skill[110] = new SkillData(1, "��M", Atb.BEAT, 1, 40, Pty.NONE, "�����Ĥ�@�H���ݩʧ���", "", 2, 0);
		Skill[111] = new SkillData(0, "���檺�u�@", Atb.BUFF, 0, 0, Pty.NONE, "�Ϧۨ������ݩʭ@�ʴ����A�ڭx��HP�V�֮ĪG�V��", "�ۨ����O�V���ĪG�ɶ��V��", 2, 1);
		Skill[112] = new SkillData(1, "�O�q����", Atb.BEAT, 1, 20, Pty.NONE, "�����Ĥ�@�H���ݩʧ����èϨ���ݩʭ@�ʤU��", "�ؼд��O�V�C�ĪG�ɶ��V��", 2, 1);
		Skill[113] = new SkillData(3, "�O�q����", Atb.BEAT, 1, 500, Pty.NONE, "�����Ĥ�������ݩʧ���", "", 4, 1);
		Skill[114] = new SkillData(1, "�b�ƳN", Atb.LIGHT, 1, 20, Pty.NONE, "�����Ĥ�@�H���ݩʧ���", "�������ݩʤW�ɮĪG", 4, 1);
		Skill[115] = new SkillData(1, "�{���N", Atb.LIGHT, 1, 60, Pty.NONE, "�����Ĥ�@�H�j�O���ݩʧ���", "", 4, 0);
		Skill[116] = new SkillData(0, "�j��", Atb.BUFF, 0, 0, Pty.NONE, "�U�^�X�ۨ������O�W��", "", 2, 1);
		Skill[117] = new SkillData(3, "������", Atb.BEAT, 1.25, 10, Pty.NONE, "�����Ĥ����j�O���ݩʧ���", "", 6, 0);
		Skill[118] = new SkillData(4, "���@�N", Atb.BUFF, 0, 0, Pty.NONE, "�ϧڤ�@�H���ݩʭ@�ʴ���", "�ۨ����O�V���ĪG�ɶ��V��", 2, 1);
		Skill[119] = new SkillData(5, "�v���N", Atb.BUFF, 0, 0, Pty.NONE, "�ϧڤ���鲧�`���A�^�_", "", 4, 1);
		Skill[120] = new SkillData(1, "���p�N", Atb.LIGHT, 1, 20, Pty.NONE, "�����Ĥ����p�ݩʧ���", "", 2, 0);
		Skill[121] = new SkillData(3, "����", Atb.LIGHT, 0.8, 10, Pty.NONE, "�����Ĥ����p�ݩʧ���", "", 4, 0);
		Skill[122] = new SkillData(1, "���K���r", Atb.FIRE, 1, 20, Pty.NONE, "�����Ĥ���骢�ݩʧ���", "�C���v�Ϩ�·�", 2, 0);
		Skill[123] = new SkillData(3, "�����N", Atb.FIRE, 0.5, 0, Pty.NONE, "�����Ĥ���骢�ݩʧ���", "", 2, 1);
		Skill[124] = new SkillData(1, "�t�v��Ĳ", Atb.DARK, 1.25, 20, Pty.NONE, "�����Ĥ����j�O���ݩʧ���", "", 6, 1);
		Skill[125] = new SkillData(3, "�A�G", Atb.DARK, 1.5, 10, Pty.NONE, "�����Ĥ����j�O���ݩʧ���", "�@�w�����v�Ϩ䤤�r", 8, 1);
		Skill[126] = new SkillData(1, "�P�R�@��", Atb.BEAT, 1, 40, Pty.NONE, "�����Ĥ�������ݩʧ����èϨ�äO�U��", "�ؼд��O�V�C�ĪG�ɶ��V��", 2, 0);
		Skill[127] = new SkillData(3, "�O�q����", Atb.BEAT, 1, 0, Pty.NONE, "�����Ĥ�������ݩʧ����èϨ�äO�U��", "�ؼд��O�V�C�ĪG�ɶ��V��", 4, 1);
		Skill[128] = new SkillData(3, "�t�v�{��", Atb.DARK, 1.25, 50, Pty.NONE, "�����Ĥ�������ݩʧ���", "�������ݩʤW��", 9, 0);
		Skill[129] = new SkillData(3, "���O", Atb.DARK, 1, 50, Pty.NONE, "�����Ĥ�������ݩʧ���", "�Ϩ���ݩʤU��", 9, 1);
		
		
		Model = new SkillModel[6];
		Model[0] = new SkillModel(0, true);
		Model[1] = new SkillModel(1, false);
		Model[2] = new SkillModel(2, false);
		Model[3] = new SkillModel(3, false);
		Model[4] = new SkillModel(4, true);
		Model[5] = new SkillModel(5, true);
	}

	public class CardData {
		
		public int HP;
		public int ATK;
		public int INT;
		public int SPD;
		public int DeckCount;
		public boolean Guard;
		public int Attribute;
		public int Group;
		public int SkillCost[] = new int[2];
		public int Skill[] = new int[2];
		
		CardData(int hp, int atk, int inte, int spd, int dc, boolean gd, int a, int g, int sc1, int sc2, int s1, int s2){
			HP = hp;
			ATK = atk;
			INT = inte;
			SPD = spd;
			DeckCount = dc;
			Guard = gd;
			Attribute = a;
			Group = g;
			SkillCost[0] = sc1;
			SkillCost[1] = sc2;
			Skill[0] = s1;
			Skill[1] = s2;
		}
	}
	
	public class SkillData {
		public int Model;
		public String Name;
		public int Attribute;
		public double Value;
		public int Root;
		public int Source;
		public String[] Comment = new String[2];
		public int Cast;
		public int Effect;
		
		SkillData(int m, String n, int a, double v, int r, int s, String c1, String c2, int c, int e) {
			Model = m;
			Name = n;
			Attribute = a;
			Value = v;
			Root = r;
			Source = s;
			Comment[0] = c1;
			Comment[1] = c2;
			Cast = c;
			Effect = e;
		}
	}
	
	public class SkillModel{
		public int TargetAmount;
		public boolean Buff;
		
		SkillModel(int ta, boolean b){
			TargetAmount = ta;
			Buff = b;
		}
	}
	
	public class AIData {
		
		public int[] Deck = new int[4];
		public String Skill;
		public String Target;
		public int MP;
		
		AIData (int d1, int d2, int d3, int d4, String s, String t, int mp){
			Deck[0] = d1;
			Deck[1] = d2;
			Deck[2] = d3;
			Deck[3] = d4;
			Skill = s;
			Target = t;
			MP = mp;
		}
	}

}
