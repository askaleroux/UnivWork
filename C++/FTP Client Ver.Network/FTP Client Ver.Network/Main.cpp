// FTP Client Ver.Network.cpp: �D�n�M���ɡC

#include "stdafx.h"
#include "Client_Form.h"

using namespace FTPClientVerNetwork;

[STAThreadAttribute]
int main(array<System::String ^> ^args)
{
	Application::EnableVisualStyles();
	Application::SetCompatibleTextRenderingDefault(false); 

	// �إߥD�����ð���
	Application::Run(gcnew Client_Form());
	return 0;
}
